package com.arnhom.bombLine.Network;

import com.arnhom.bombLine.Network.TransferPOJO.Envelope;
import com.sun.tools.internal.xjc.ConsoleErrorReporter;

import java.net.*;
import java.io.*;
import java.util.List;
import java.util.Vector;

public class Server {

    private final int listeningPort;
    private Thread listeningThread;
    private final ConnectionBuilder connectionBuilder;
    private List<Connection> connections = new Vector<>();
    private final int listenTimeoutSeconds = 5;
    private boolean keepListening = false;

    public Server(int port, ConnectionBuilder connectionBuilder){
        listeningPort = port;
        this.connectionBuilder = connectionBuilder;
    }

    public boolean isListening(){
        return listeningThread != null && listeningThread.isAlive();
    }

    public boolean listeningThreadIsStopping(){
        return keepListening == false;
    }

    public void startListening(){
        if(this.isListening()){
            System.out.println("cannot start listening as the server is already listening");
            if(listeningThreadIsStopping()){
                System.out.println("... but the listening thread is attempting to stop.  Will keep the thread from stopping");
                keepListening = true;
            }
            else{
                System.out.println("and the listening thread does not plan to stop.");
            }
            return;
        }
        keepListening = true;
        listeningThread = new Thread(() ->{
            try {
                ServerSocket serverSocket = new ServerSocket(listeningPort);
                serverSocket.setSoTimeout(listenTimeoutSeconds * 1000);
                System.out.println("Began listening on port " + listeningPort);

                while (keepListening) {
                    try {
                        Socket clientSocket = serverSocket.accept();
                        Connection connection = connectionBuilder.build(clientSocket);
                        connections.add(connection);
                    } catch (SocketTimeoutException e) {
                        if (!keepListening) {
                            System.out.println("socket timeout reached and keeplistening is false. Will stop listening.");
                        }
                    } catch (IOException e) {
                        System.out.println("Exception caught when trying to listen on port "
                                + listeningPort + " or listening for a connection");
                        System.out.println(e.getMessage());
                    }
                }
            }
            catch(IOException e){
                System.out.println("Exception caught when trying to open a server socket on port "
                        + listeningPort);
                System.out.println(e.getMessage());
            }
            System.out.println("Listening thread has ended.");
        });
        listeningThread.start();
    }

    public void stopListening(){
        System.out.println("received command to stop listening. The thread will exit once the timeout is reached.");
        keepListening = false;
    }

    public void sendAll(Envelope message){
        message.cid = "server";
        for(Connection connection: connections){
            connection.sendMessage(message);
        }
    }

    public void stopListeningAndWaitForThreadToExit(){
        stopListening();
        System.out.println("Now wait for the thread to die.");
        try {
            listeningThread.join();
        }
        catch(Exception e){
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }
    }
}

