/// @description Insert description here
// You can write your code in this editor
var incomingData = listenToSocket(clientSocket);
if( incomingData == pointer_null){
	return;	
}
// otherwise we got a string.
var env = json_parse(incomingData);

if(env.type == type_tennisBall){
	show_debug_message("we caught the tennis ball");
	var ball = envelopeOpen(env);
	tennisBall_bounce(ball);
	tennisBall = ball;
	alarm_set(0,60);
}
else{
	show_debug_message("Not sure what this data is, sorry");
}