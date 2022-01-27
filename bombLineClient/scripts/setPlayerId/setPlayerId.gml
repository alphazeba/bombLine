// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function setPlayerId(playerId){
	show_debug_message("setting the player id to : " +  playerId);
	show_debug_message(playerId);
	gameController.playerId = playerId;
}