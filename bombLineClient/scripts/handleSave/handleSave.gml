// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function handleSave(){
	var src= self;
	var pojo = {
		width: src.width,
		height: src.height,
		
		boxes: src.boxes,
		sl: src.spawnLocations
	}//TODO write itself to a pojo
	savePojoToDisk(pojo);
}