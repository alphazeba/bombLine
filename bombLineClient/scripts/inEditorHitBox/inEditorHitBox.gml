// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function inEditorHitBox(){
	return mouse_x > editor_ox and mouse_x < editor_ox + editor_w and mouse_y > editor_oy and mouse_y < editor_oy + editor_h;
}