/// @description Insert description here
// You can write your code in this editor
if(connectionState != "enterConnectionInfo"){
	return;	
}

// type based on allowed characters;
var allowedOrd = [
	"1","2","3","4","5","6","7","8","9","0",".",":"
];
if(keyboard_check_pressed(vk_anykey)){
	for(var i=0;i<array_length(allowedOrd); i++){	
		char= allowedOrd[i];
		if(char == keyboard_lastchar){
			input += char;	
		}
	}
}
keyboard_lastchar = "";

// typed based on vk_key mapper.
var keyMap = [
];
for(var i=0;i<array_length(keyMap); i++){
	var keyCheck = keyMap[i][0];
	var char = keyMap[i][1];
	if(keyboard_check_pressed(keyCheck)){
		input += char;	
	}
}


// handle backspace.
if(keyboard_check_pressed(vk_backspace)){
	var numCharacters = string_length(input);
	if(numCharacters > 0){
		input = string_delete(input,numCharacters,1);	
	}
}

if(keyboard_check_pressed(vk_enter)){
	var ip = defaultIp;
	var port = defaultPort;
	
	if(string_length(input) > 0){
		
		var splitInput = stringSplit(input,":");
		ip = splitInput[0];
		if(array_length(splitInput) > 1){
			port = 	real(splitInput[1]);
		}
	}
	
	show_debug_message("connecting using ip: " + ip);
	show_debug_message("connection using port: " + string(port));
	clientSocket = connectToServer(ip,port);
	connectionState = "getConnectionId";
	alarm[0] = 1;
	attempts = 0;
}