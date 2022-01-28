// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function updatePlayer(player,pojo){
	setx(player, pojo.x);
	sety(player, pojo.y);
	player.active = pojo.active;
	player.style = pojo.style;
}