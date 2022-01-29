// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function addSpawnLocation(ox,oy){
	var l = array_length(spawnLocations);
	spawnLocations[l] = {
		x: ox,
		y: oy
	}
}