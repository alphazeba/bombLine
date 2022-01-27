// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function updateGameState(state){
	var objMap = getObjectMap();
	
	// for every item in the state
	var numObjs = array_length(state.objs);
	for(var i=0;i<numObjs; i++){
		var incoming = state.objs[i];
		
		var here = ds_map_find_value(objMap,incoming.oid);
	}
	
}