package com.arnhom.bombLine.Network.MessageHandler;

import com.arnhom.bombLine.Game.Player;
import com.arnhom.bombLine.Network.ConnectionMailer;
import com.arnhom.bombLine.Network.ConnectionMessageHandler;
import com.arnhom.bombLine.Network.ConnectionPushAndMessageHandler;
import com.arnhom.bombLine.Network.TransferPOJO.Envelope;
import com.arnhom.bombLine.Utility.Guid;

public class PlayerHandler implements ConnectionPushAndMessageHandler {

    private String connectionId = "none";
    private String name = "defaultPlayerHandlerName" + Guid.generate();
    private Player player;

    private ConnectionMailer mailer;

    private static final String e_setName = "setName";

    @Override
    public void handleMessage(Envelope message) {
        connectionId = message.cid;

        //TODO consider attempting to throttle the amount of traffic that is being sent?

        if(weHaveAPlayer()){
            handlePlayerEvents(message);
        }
        handleGeneralEvents(message);
    }

    public void assignPlayer(Player player){
        this.player = player;

    }

    public void unassignPlayer(){
        this.player = null;
    }

    private void handleGeneralEvents(Envelope message){

    }

    private void handlePlayerEvents(Envelope message){
        if(message.is(e_setName)){
            String newName = message.open(String.class);
            //TODO verify that the newName is unique
            player.setName(newName);
        }
    }

    private boolean weHaveAPlayer(){
        return player != null;
    }

    @Override
    public void pushMessage(Envelope message) {
        mailer.sendEnvelope(message);
    }
}
