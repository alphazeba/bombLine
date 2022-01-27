/// @description Insert description here
// You can write your code in this editor

alarm[0] = pingPeriod;

if(connectionState == "getConnectionId"){
	if(getConnectionID() != global.null_connection){
		connectionState = "getPlayerId";
		alarm[0] = 1;
	}
	else{
		networkSendString(clientSocket, requestDrip());
	}	
}
else if(connectionState == "getPlayerId"){
	
	if(getPlayerId() != global.null_playerId){
		connectionState = "success";	
	}
	else{
		networkSendString(clientSocket, requestGetPlayerId() );
	}
}