/// @description Insert description here
// You can write your code in this editor


if( keyboard_check_pressed(ord("P"))){
	room_goto(networkingTest)	
}

var keyFnMap = [
	[vk_up, handleDecreaseHeight],
	[vk_down, handleIncreaseHeight],
	[vk_left, handleDecreaseWidth],
	[vk_right, handleIncreaseWIdth]
];

for(var i=0;i<array_length(keyFnMap);i++){
	var key = keyFnMap[i][0];
	var handler = keyFnMap[i][1];
	if(keyboard_check_pressed(key)){
		script_execute(handler,boxes);	
	}
}

stepEditorUi();