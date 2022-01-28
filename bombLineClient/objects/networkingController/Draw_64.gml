/// @description Insert description here
// You can write your code in this editor

if(connectionState == "success"){
	return;	
}

draw_text(50,0, "connectionState: " + connectionState);

if(connectionState == "enterConnectionInfo"){
	draw_text(50,100, "connect to: " + input);
	draw_text(50,150, "press enter to connect");
	draw_text(50,200, keyboard_lastchar);
}