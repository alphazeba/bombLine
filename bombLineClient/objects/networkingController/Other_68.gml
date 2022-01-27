/// @description Insert description here
// You can write your code in this editor
var incomingData = listenToSocket(clientSocket);
if( incomingData == pointer_null){
	return;	
}
// otherwise we got a string.
var env = json_parse(incomingData);


if(handleDrop(env)){
	networkSendString(clientSocket, getPlayerId() );
}
else if(handlePlayerId(env)){}
