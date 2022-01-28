// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function inHitBox(ox,oy,hx,hy,hw,hh){
	
	return ox > hx and ox < hx+hw and oy > hy and oy < hy+hh;
	
}