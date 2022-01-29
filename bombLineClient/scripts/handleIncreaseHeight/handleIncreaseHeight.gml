// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function handleIncreaseHeight(){
	
	if(height >= 12){
		return;	
	}
	
	var endOfCurrentData = array_length(boxes);
	
	for(var i =0;i < width; i++){
		boxes[endOfCurrentData + i] = 0;
	}
	
	height++;
}