// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function handleLoad(){
	var pojo = loadPojoFromDisk();
	// now use an update to write to itself.
	updateLevel(self,pojo);
}