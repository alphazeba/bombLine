// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function removeSpawnLocation(ox,oy){
	var newSpawnLocations = []
	var ni = 0;
	for(var i=0;i<array_length(spawnLocations);i++){
		var curSl = spawnLocations[i];
		if(spawnLocationEquals(curSl,ox,oy)){
			// do nothing	
		}
		else {
			newSpawnLocations[ni] = spawnLocations[i];	
			ni++;
		}
	}
	spawnLocations = newSpawnLocations;
}