// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function handlePlayerId(env){
	if(env.type == "playerId"){
	
		setPlayerId(envelopeOpen(env));
	
		return true;
	}
	return false;
}