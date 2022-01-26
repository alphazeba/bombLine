// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function isTennisBall(obj){
	show_debug_message(obj);
	return variable_struct_exists(obj,"type") and obj.type == "tennisBall";
}