// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function handleIncreaseWIdth(){
	
	if(width >= 21){
		return;
	}	
	
	var newData = [];
	var newWidth = width+1;
	
	for(var iy=0;iy<height;iy++){
		for(var ix=0;ix<width;ix++){
			var oldi = iy*width+ix;
			var newi = iy*newWidth+ix;
			
			newData[newi] = boxes[oldi];
			
		}
		// fill in the end of the row.
		newData[iy*newWidth+width] = 0;
	}
	
	width = newWidth;
	boxes = newData;
	
}