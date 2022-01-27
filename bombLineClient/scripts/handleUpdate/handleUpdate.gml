// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function handleUpdate(env){
	if(env.type == "update"){
	
		var state = envelopeOpen(env);
		updateGameState(state);
	
		return true;
	}
	return false;
}