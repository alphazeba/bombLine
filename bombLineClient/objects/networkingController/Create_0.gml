/// @description Insert description here
// You can write your code in this editor

global.null_connection = "noConnectionId";
connectionId = global.null_connection;

defaultIp = "127.0.0.1";
defaultPort = 8080;

input = "";

attempts = 0;

clientSocket = pointer_null;

pingPeriod = 60;
connectionState = "enterConnectionInfo";
alarm[0] = 1;

