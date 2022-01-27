// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function updateObjectWithPojo(obj, pojo){
	var type = pojo.type;
	if(type == "player"){
		updatePlayer(obj,pojo);	
	}
	else if(type == "bomb"){
		updateBomb(obj,pojo);
	}
	else if(type == "fire"){
		updateFire(obj,pojo);
	}
}