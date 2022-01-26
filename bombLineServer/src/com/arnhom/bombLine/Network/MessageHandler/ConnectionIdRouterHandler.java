package com.arnhom.bombLine.Network.MessageHandler;

import com.arnhom.bombLine.Network.ConnectionMessageHandler;
import com.arnhom.bombLine.Network.ConnectionPushAndMessageHandlerBuilder;
import com.arnhom.bombLine.Network.ConnectionPushAndMessageHandler;
import com.arnhom.bombLine.Network.ConnectionPushHandler;
import com.arnhom.bombLine.Network.TransferPOJO.Envelope;
import com.arnhom.bombLine.Utility.Guid;

import java.util.Map;

public class ConnectionIdRouterHandler implements ConnectionMessageHandler, ConnectionPushHandler {

    Map<String, ConnectionPushAndMessageHandler> connectionHandlers;
    ConnectionPushAndMessageHandlerBuilder handlerBuilder;

    public ConnectionIdRouterHandler(ConnectionPushAndMessageHandlerBuilder handlerBuilder){
        this.handlerBuilder = handlerBuilder;
    }

    @Override
    public void handleMessage(Envelope message) {
        ConnectionMessageHandler targetHandler;

        if(isNewConnection(message.cid)){
            message.cid = generateConnectionId();
            ConnectionPushAndMessageHandler newHandler = handlerBuilder.build();
            connectionHandlers.put(message.cid, newHandler);
            targetHandler = newHandler;
        }
        else {
            targetHandler = connectionHandlers.get(message.cid);
        }
        targetHandler.handleMessage(message);
    }

    private String generateConnectionId(){
        return "cid_" + Guid.generate();
    }

    private boolean isNewConnection(String connectionId){
        // if the cid is new.
        return !connectionHandlers.containsKey(connectionId);
    }

    @Override
    public void pushMessage(Envelope message) {
        for( String cid: connectionHandlers.keySet()){
            ConnectionPushAndMessageHandler handler = connectionHandlers.get(cid);
            Envelope curMessage = message.copy();
            curMessage.cid = cid;
            handler.pushMessage(curMessage);
        }
    }
}
