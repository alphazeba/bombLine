package com.arnhom.bombLine.Network.GameMaker;

import com.arnhom.bombLine.Network.Connection;
import com.arnhom.bombLine.Network.ConnectionBuilder;
import com.arnhom.bombLine.Network.ConnectionIO;
import com.arnhom.bombLine.Network.ConnectionMessageHandler;
import com.arnhom.bombLine.Network.MessageHandler.EchoHandler;
import com.arnhom.bombLine.Network.MessageHandler.TennisHandler;

import java.io.IOException;
import java.net.Socket;

public class GameMakerConnectionBuilder implements ConnectionBuilder {
    @Override
    public Connection build(Socket socket) throws IOException {
        ConnectionIO io = new GameMakerConnectionIO(socket);
        ConnectionMessageHandler handler = new TennisHandler(io);
        return new Connection(socket, io, handler);
    }
}
