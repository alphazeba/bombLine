// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function handleDecreaseWidth(){
	if(width <= 1){
		return; // do nothing	
	}
	
	var newWidth = width-1;
	
	var newData = [];
	var newi = 0;
	
	
	for(var iy=0;iy<height;iy++){
		for(var ix =0;ix < newWidth; ix++){
			var oldi = width*iy + ix;
			
			newData[newi] = boxes[oldi];
			
			newi++;
		}
	}
	
	boxes = newData;
	width = newWidth;
	removeSpawnLocationsOutsideLevel()
}