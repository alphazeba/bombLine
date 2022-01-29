// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function updateGameState(state){
	var objMap = getObjectMap();
	
	// for every item in the state
	var numObjs = array_length(state.objs);
	for(var i=0;i<numObjs; i++){
		var pojo = state.objs[i];
		var oid = pojo.oid;
		var gm_obj;
		if( ds_map_exists( objMap, oid )){
			gm_obj = ds_map_find_value(objMap, oid );	
		}
		else {
			gm_obj = createObjectFromPojo(pojo);
			ds_map_add(objMap, oid, gm_obj);
		}
		
		updateObjectWithPojo(gm_obj,pojo);
	}
	
	
	// now handle the dead ids.
	var numDeadIds = array_length(state.deadIds);
	
	for(var i =0; i < numDeadIds; i++){
		var deadId = state.deadIds[i];
		var objToDelete = ds_map_find_value(objMap, deadId);
		ds_map_delete(objMap, deadId);
		instance_destroy(objToDelete);
	}
	
	// update the level
	updateLevel(obj_level, state.level);
}