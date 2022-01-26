package com.arnhom.bombLine;

import com.arnhom.bombLine.Network.GameMaker.GameMakerConnectionBuilder;
import com.arnhom.bombLine.Network.Server;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Server server = new Server(8080, new GameMakerConnectionBuilder());
        server.startListening();
    }
}
