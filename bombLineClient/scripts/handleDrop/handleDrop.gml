// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function handleDrop(env){
	if(env.type == "drop"){
		
		envelopeOpen(env);
		
		return true;
	}
	return false;
}