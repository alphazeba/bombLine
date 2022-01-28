// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function stepEditorUi(){
		
	if(editor_draggable_clicked){
		
		editor_ox = mouse_x + editor_draggable_mouseOffset_x;
		editor_oy = mouse_y + editor_draggable_mouseOffset_y;
		
		if(mouse_check_button_released(mb_left)){
			editor_draggable_clicked = false;	
		}
	}
	else {
		if(mouse_check_button_pressed(mb_left) and inDraggableHitBox()){
			editor_draggable_clicked = true;
			editor_draggable_mouseOffset_x = editor_ox - mouse_x;
			editor_draggable_mouseOffset_y = editor_oy - mouse_y;
		}
	}
	
	// handle the editor button presses
	for(var i =0; i < array_length(editor_buttons); i++){
		var button = editor_buttons[i];
		var size = button_getSize(button);
		var bx = size[0];
		var by = size[1];
		var bw = size[2];
		var bh = size[3];
		var bhandler = button_getHandler(button);
		
		if(mouse_check_button_pressed(mb_left) and inHitBox(mouse_x,mouse_y,bx+editor_ox, by+editor_oy, bw, bh)){
			script_execute(bhandler);
		}
	}
	
	// handle the drawing on the level
	if(mouse_check_button(mb_left) and not inEditorHitBox()){
		var cellWidth = 64;
		var cellHeight = 64;
		// get the cell of the mouse.
		var cellx = floor( mouse_x / cellWidth );
		var celly = floor( mouse_y / cellHeight);
		
		// if the cell is within the level set the box to the currently selected value
		
		if( cellx >= 0 and cellx < width and celly >= 0 and celly < height){
			boxi = celly*width + cellx;
			boxes[boxi] = editor_selected;
		}
		
	}
	
	

}