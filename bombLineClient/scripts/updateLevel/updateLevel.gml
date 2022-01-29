// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function updateLevel(level, pojo){
	var levelPojo = pojo;
	level.width = levelPojo.width;
	level.height = levelPojo.height;
	level.boxes = levelPojo.boxes;
	if(variable_struct_exists(levelPojo,"sl")){
		level.spawnLocations = levelPojo.sl;
	}
}