// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function button_getSize(button){
	var output = []
	output[0] = button[0] // x 
	output[1] = button[1] // y
	output[2] = button[2] // w
	output[3] = button[3] // h
	return output;
}