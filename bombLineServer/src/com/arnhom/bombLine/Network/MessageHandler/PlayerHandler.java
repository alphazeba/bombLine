package com.arnhom.bombLine.Network.MessageHandler;

import com.arnhom.bombLine.Game.Player;
import com.arnhom.bombLine.Game.World;
import com.arnhom.bombLine.Network.ConnectionMailer;
import com.arnhom.bombLine.Network.ConnectionMessageHandler;
import com.arnhom.bombLine.Network.TransferPOJO.Envelope;
import com.arnhom.bombLine.Network.TransferPOJO.Intent;
import com.arnhom.bombLine.Network.TransferPOJO.MessagePojo;
import com.arnhom.bombLine.Network.TransferPOJO.StatePojo;
import com.arnhom.bombLine.Utility.Guid;

public class PlayerHandler implements ConnectionMessageHandler {

    private String connectionId = "none";
    private String name = "defaultPlayerHandlerName" + Guid.generate();
    private Player player;

    private ConnectionMailer mailer;
    private World world;

    private static final String null_cid = "noConnectionId";

    private static final String i_setName = "setName";
    private static final String i_intent = "intent";
    private static final String i_getPlayerId = "getPlayerId";

    private static final String i_resetWorld = "resetWorld";

    private static final String i_drip = "drip";
    private static final String o_drop = "drop";

    private static final String o_playerId = "playerId";
    private static final String o_message = "message";


    public PlayerHandler(World world, ConnectionMailer mailer){
        this.world = world;
        this.mailer = mailer;
    }

    private boolean isNewConnection(Envelope message){
        return message.cid.equals(null_cid);
    }

    private String generateConnectionId(){
        return "cid_" + Guid.generate();
    }

    @Override
    public void handleMessage(Envelope message) {
        if(isNewConnection(message)){
            message.cid = generateConnectionId();
        } // if the user reports a cid, we will use it.
        connectionId = message.cid;

        //TODO consider attempting to throttle the amount of traffic that is being sent?

        if(weHaveAPlayer()){
            handlePlayerEvents(message);
        }
        else{
            handleNoPlayerEvents(message);
        }
        handleGeneralEvents(message);
    }

    public void unassignPlayer(){
        this.player = null;
    }

    private void handleGeneralEvents(Envelope message){
        if(message.is(i_drip)){
            pushMessage(sealEnvelope(o_drop,":)"));
        }
        else if(message.is(i_resetWorld)){
            pushMessage(sealEnvelope(o_message,new MessagePojo("Server","Player " + player.getName() + " has reset the level")));
            StatePojo deadState = world.reinitialize();
            pushMessage(sealEnvelope("update", deadState));
            // TODO pushing the dead state is trying
            // to set up a way to erase everything and
            // then start over, but it doesn't really
            // work.  If you reset while there are
            // fire on the screen, the fire do not
            // go away.  Could give fire a max
            // lifespan.
        }
    }

    private void handleNoPlayerEvents(Envelope message){
        if(message.is(i_getPlayerId)){
            player = world.requestPlayer(message.cid);
            pushMessage(sealEnvelope(o_playerId, player.getId()));
        }
    }

    private void handlePlayerEvents(Envelope message){
        if(message.is(i_setName)){
            String newName = message.open(String.class);
            //TODO verify that the newName is unique
            player.setName(newName);
        }
        else if(message.is(i_intent)){
            Intent intent = message.open(Intent.class);
            if(intent.dropBomb){
                player.intendToBomb();
            }
            player.intendMove(intent.getVector());
        }
        else if(message.is(i_getPlayerId)){
            Envelope response = sealEnvelope(o_playerId, player.getId());
            pushMessage(response);
        }
    }

    private boolean weHaveAPlayer(){
        return player != null;
    }

    private Envelope sealEnvelope(String messageType, Object contents){
        Envelope env = new Envelope(messageType);
        env.cid = connectionId;
        return env.fill(contents);
    }

    public void pushMessage(Envelope message) {
        mailer.sendEnvelope(message);
    }
}
