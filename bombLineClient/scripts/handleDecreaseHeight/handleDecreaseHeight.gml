// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function handleDecreaseHeight(){
	
	if(height <= 1){
		return; // do nothing	
	}
	
	var newHeight = height-1;
	
	var newData = [];
	var newi = 0;
		
	for(var iy=0;iy<newHeight;iy++){
		for(var ix =0;ix < width; ix++){
			var oldi = width*iy + ix;
			
			newData[newi] = boxes[oldi];
		
			newi++;
		}
	}
	
	boxes = newData;
	height = newHeight;
}