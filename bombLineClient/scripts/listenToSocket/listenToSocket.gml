// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function listenToSocket(socket){

	var incomingId = ds_map_find_value(async_load, "id");
	if(incomingId == socket){
		var t_buffer = ds_map_find_value(async_load, "buffer"); 
	    var receivedData = buffer_read(t_buffer, buffer_string );
	    
		return receivedData;
	}
	return pointer_null;
}