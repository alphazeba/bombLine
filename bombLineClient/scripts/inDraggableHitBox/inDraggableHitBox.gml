// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function inDraggableHitBox(){
	// handle editor clicks
	if(mouse_x > editor_ox and mouse_x < editor_ox+editor_w and mouse_y > editor_oy and mouse_y < editor_oy+editor_draggable_height){
		return true;	
	}
	return false;
}