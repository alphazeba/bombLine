// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function removeSpawnLocationsOutsideLevel(){
	var toRemove = []
	var removed = 0;
	for(var i= 0;i<array_length(spawnLocations);i++){
		var sl = spawnLocations[i];
		if(spawnLocationGetX(sl) >= width or spawnLocationGetY(sl) >= height){
			toRemove[removed] = i;
			removed++;
		}
	}
	
	var newSpawnLocations = []
	var ni = 0;
	var ri = 0;
	for(var i=0;i<array_length(spawnLocations);i++){		
		if(ri < array_length(toRemove)){
			if(i==toRemove[ri]){
				ri++;	
			}
			else{
				newSpawnLocations[ni] = spawnLocations[i];	
				ni++;	
			}
		}
		else{
			newSpawnLocations[ni] = spawnLocations[i];	
			ni++;
		}
	}
	spawnLocations = newSpawnLocations;
}