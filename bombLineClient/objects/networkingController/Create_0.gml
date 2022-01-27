/// @description Insert description here
// You can write your code in this editor


connectionId = "noConnectionId";
clientSocket = connectToServer("127.0.0.1",8080);

networkSendString(clientSocket, drip());
