package com.arnhom.bombLine.Network.MessageHandler;

import com.arnhom.bombLine.Network.ConnectionIO;
import com.arnhom.bombLine.Network.ConnectionMessageHandler;
import com.arnhom.bombLine.Network.TransferPOJO.Envelope;
import com.arnhom.bombLine.Network.TransferPOJO.TennisBall;

public class TennisHandler implements ConnectionMessageHandler {

    private ConnectionIO io;
    final String tennisBall = "tennisBall";

    public TennisHandler(ConnectionIO io){
        this.io = io;
    }

    @Override
    public void handleMessage(Envelope message) {
        if(message.is(tennisBall)){
            TennisBall ball = message.open(TennisBall.class);
            handleTennisBall(message,ball);
        }
    }


    public void handleTennisBall(Envelope env, TennisBall ball){
        ball.bounce();
        io.sendEnvelope(env.fill(ball));
    }
}

