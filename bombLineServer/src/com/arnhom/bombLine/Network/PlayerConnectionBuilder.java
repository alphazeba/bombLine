package com.arnhom.bombLine.Network;

import com.arnhom.bombLine.Game.World;
import com.arnhom.bombLine.Network.GameMaker.GameMakerConnectionIO;
import com.arnhom.bombLine.Network.MessageHandler.PlayerHandler;

import java.io.IOException;
import java.net.Socket;

public class PlayerConnectionBuilder implements ConnectionBuilder{

    World world;

    public PlayerConnectionBuilder(World world){
        this.world = world;
    }

    @Override
    public Connection build(Socket socket) throws IOException {
        ConnectionIO io = new GameMakerConnectionIO(socket);
        PlayerHandler handler = new PlayerHandler(world, io);
        Connection connection = new Connection(socket, io, handler);
        return connection;
    }
}
