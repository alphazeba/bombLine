// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function networkSendString(socket,string){
	show_debug_message( "-> sending: " + string)
	var buffer = stringToBuffer(
		cleanStringForSending(string)
	)
	network_send_raw(socket,buffer,buffer_get_size(buffer));
	buffer_delete(buffer);
}