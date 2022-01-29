// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function savePojoToDisk(pojo){
	var pojoString = json_stringify(pojo)
	saveOverwriteStringToFile(pojoString,"bombLevel|*.bomb","bomberLevel.bomb");
}