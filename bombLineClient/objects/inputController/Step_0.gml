/// @description Insert description here
// You can write your code in this editor


if(keyboard_check_pressed(ord("L"))){
	room_goto(levelEditor);
}

if(networkingController.connectionState != "success"){
	return;	
}

var mappingList = [
	[ ord("S"), "x" ],
	[ ord("D"), "d" ],
	[ ord("A"), "a" ],
	[ ord("W"), "w" ]
]


var nextMoveIntent = "s";
var nextBombIntent = false;

for(var i=0;i< array_length(mappingList); i++){
	var key = 	mappingList[i][0];
	var intent = mappingList[i][1];
	
	if( keyboard_check(key) ){
		nextMoveIntent = intent;	
	}
}
	
	
if(keyboard_check_pressed(vk_space)){
	nextBombIntent = true;	
}
	
if(nextMoveIntent != moveIntent or nextBombIntent != bombIntent){
	// TODO need to send the intent to the network controller.	
	moveIntent = nextMoveIntent;
	bombIntent = nextBombIntent;
	notifyIntentUpdate(nextMoveIntent, nextBombIntent);
}


if( keyboard_check_pressed(ord("R")) ){
	with(networkingController){
		networkSendString(clientSocket, requestResetWorld());
	}
}
if(keyboard_check_pressed(ord("O"))){
	with(networkingController){
		var level = loadPojoFromDisk();
		networkSendString(clientSocket, requestUploadLevel(level));
	}
}