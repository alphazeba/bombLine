// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function drawEditorUi(ox,oy){
	
	var w = editor_w
	var h = editor_h;
	// draw background
	draw_set_color(c_gray);
	draw_rectangle(ox,oy, ox+w, oy+h,false);
	
	// draw the buttons
	for(var i= 0;i < array_length(editor_buttons); i++){
		var button = editor_buttons[i];
		
		var size = button_getSize(button);
		var bx = size[0];
		var by = size[1];
		var bw = size[2];
		var bh = size[3];
		var spr = button_getSpr(button);
		
		draw_set_color(c_black);
		draw_rectangle( ox+bx, oy+by, ox+bx+bw, oy+by+bh , false);
		
		// get the amount to offset the sprite to center the sprite on the button
		var offsetx = (bw - sprite_get_width(spr))/2;
		var offsety = (bh - sprite_get_height(spr))/2;
		
		draw_sprite(spr, 0, ox+bx+offsetx, oy+by+offsety);
	}
	
	// draw the selected item.
	var selectedSprite;
	if(editor_selected == 1){
		selectedSprite = spr_box;	
	}
	else if(editor_selected == -1){
		selectedSprite = spr_unbreakableBox;	
	}
	else if(editor_selected == 0){
		selectedSprite = spr_erase;	
	}
	
	draw_sprite_stretched(selectedSprite, 0, editor_selected_x+ox, editor_selected_y+oy, 128, 128);
	
	
	
	// draw the dragable
	draw_set_color(c_black);
	draw_line(ox,oy+editor_draggable_height,ox+w,oy+editor_draggable_height);
	
}