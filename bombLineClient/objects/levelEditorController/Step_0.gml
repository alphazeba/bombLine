/// @description Insert description here
// You can write your code in this editor


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