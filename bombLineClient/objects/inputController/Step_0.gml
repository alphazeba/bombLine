/// @description Insert description here
// You can write your code in this editor

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