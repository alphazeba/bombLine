// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function createObjectFromPojo(pojo){
	var obj;
	var type = pojo.type;
	if(type == "player"){
		obj = instance_create_depth(0,0,0,obj_player);	
	}
	else if(type = "bomb"){
		obj = instance_create_depth(0,0,0,obj_bomb);
	}
	else if(type = "fire"){
		obj = instance_create_depth(0,0,0,obj_fire);
	}
	
	return obj;
}