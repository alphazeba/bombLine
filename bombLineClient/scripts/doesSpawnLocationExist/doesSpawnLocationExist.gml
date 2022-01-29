// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function doesSpawnLocationExist(ox,oy){
	for(var i=0;i<array_length(spawnLocations); i++){
		var sl = spawnLocations[i];
		if( spawnLocationEquals(sl, ox,oy) ){
			return true;	
		}
	}
	return false;
}