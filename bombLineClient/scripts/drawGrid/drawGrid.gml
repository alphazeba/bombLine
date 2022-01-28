// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function drawGrid(width,height,spr,data,value){
	var celli = 0;
	for(var iy =0;iy<height; iy++){
		for(var ix=0; ix< width; ix++){
			if(data[celli] == value){
				draw_sprite(spr,0,ix*64,iy*64);	
			}
			celli++
		}
	}
}