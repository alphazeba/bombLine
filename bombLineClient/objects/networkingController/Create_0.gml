/// @description Insert description here
// You can write your code in this editor

global.null_connection = "noConnectionId";
connectionId = global.null_connection;
clientSocket = connectToServer("127.0.0.1",8080);

pingPeriod = 60;
connectionState = "getConnectionId";
alarm[0] = 1;

