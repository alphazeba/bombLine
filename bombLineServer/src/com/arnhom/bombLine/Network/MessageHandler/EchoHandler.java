package com.arnhom.bombLine.Network.MessageHandler;

import com.arnhom.bombLine.Network.ConnectionIO;
import com.arnhom.bombLine.Network.ConnectionMessageHandler;
import com.arnhom.bombLine.Network.TransferPOJO.Envelope;

public class EchoHandler implements ConnectionMessageHandler {

    ConnectionIO io;

    public EchoHandler(ConnectionIO io){
        this.io = io;
    }

    @Override
    public void handleMessage(Envelope message) {
        // echoes it back;
        System.out.println("received from gamemaker: " + message);
        io.sendEnvelope(message);
    }
}
