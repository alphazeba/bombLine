// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function connectToServer(address,port){
	show_debug_message("entering creating socket");
	var clientSocket = network_create_socket(network_socket_tcp);
	
	// try to connect now
	network_connect_raw(clientSocket, address, port);
	
	show_debug_message("finished connecting");
	return clientSocket
}