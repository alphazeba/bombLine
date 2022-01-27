// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function updateFire(fire,pojo){
	setx(fire,pojo.x);
	sety(fire,pojo.y);
	fire.blastSize = pojo.blastSize;
}