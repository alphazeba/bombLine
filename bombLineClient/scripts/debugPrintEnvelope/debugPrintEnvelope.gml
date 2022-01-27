// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function debugPrintEnvelope(env){
	
	var ignoredTypes = [
		"update"
	]
	
	var type = env.type;
	
	for(var i = 0; i < array_length(ignoredTypes); i++){
		if (type == ignoredTypes[i]){
			return;	
		}
	}
	
	show_debug_message("<- receiving: ");
	show_debug_message(env);

}