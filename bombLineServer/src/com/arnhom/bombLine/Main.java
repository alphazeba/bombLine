package com.arnhom.bombLine;

import com.arnhom.bombLine.Game.World;
import com.arnhom.bombLine.Network.GameMaker.GameMakerConnectionBuilder;
import com.arnhom.bombLine.Network.GameMaker.GameMakerConnectionIO;
import com.arnhom.bombLine.Network.MessageHandler.PlayerHandlerBuilder;
import com.arnhom.bombLine.Network.PlayerConnectionBuilder;
import com.arnhom.bombLine.Network.Server;
import com.arnhom.bombLine.Network.TransferPOJO.Envelope;
import com.arnhom.bombLine.Network.TransferPOJO.StatePojo;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {
	    // runTennisTest();
        runGame();
    }

    public static void runTennisTest(){
        Server server = new Server(8080, new GameMakerConnectionBuilder());
        server.startListening();
    }

    public static void runGame() throws Exception {
        World world = new World();

        PlayerConnectionBuilder playerConnectionBuilder = new PlayerConnectionBuilder(world);

        Server server = new Server(8080, playerConnectionBuilder);
        server.startListening();

        float fps = 60;
        int frameTimeMillis = (int)(1000.f/fps);

        while(true){

            StatePojo state = world.update();
            Envelope stateMessage = new Envelope( "update" );
            stateMessage.fill(state);

            server.sendAll(stateMessage);

            TimeUnit.MILLISECONDS.sleep(frameTimeMillis);
        }

    }
}
