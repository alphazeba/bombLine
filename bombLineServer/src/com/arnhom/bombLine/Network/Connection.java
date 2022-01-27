package com.arnhom.bombLine.Network;

import com.arnhom.bombLine.Network.TransferPOJO.Envelope;

import java.io.*;
import java.net.*;

public class Connection {

    Socket socket;
    ConnectionIO io;
    ConnectionMessageHandler handler;
    Thread readThread;

    public Connection(Socket socket, ConnectionIO io, ConnectionMessageHandler handler) throws IOException {
        this.socket = socket;
        this.io = io;
        this.handler = handler;
        this.readThread = new Thread(() -> {
            Envelope input;
            while((input = io.getMail()) != null){
                if(input != null){
                    handler.handleMessage(input);
                }
            }
        });
        readThread.start();
    }

    public void sendMessage(Envelope message){
        io.sendEnvelope(message);
    }

}
