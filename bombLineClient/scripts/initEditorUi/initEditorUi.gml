// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function initEditorUi(){
	editor_ox = 300;
	editor_oy = 20;
	
	editor_numButtons = 0;
	editor_buttons = [];
	
	editor_selected = 1;
	
	var ebw = 70;
	var ebh = 70;
	
	var buttonHeight = 40;
	var buffer = 10;
	
	initEditorButton(buffer,buttonHeight,ebw,ebh,spr_box,handleSelectBox);
	initEditorButton(buffer*2+ebw,buttonHeight,ebw,ebh,spr_unbreakableBox,handleSelectUnbreakable);
	initEditorButton(buffer*3+ebw*2,buttonHeight,ebw,ebh,spr_erase,handleSelectErase);
	
	
	var buttonHeight2 = 300;
	initEditorButton(buffer, buttonHeight2, ebw, ebh, spr_load, handleSelectBox);
	initEditorButton(buffer*2+ebw, buttonHeight2, ebw,ebh, spr_save, handleSelectBox);
	
	
	editor_w = buffer*4+ebw*3;
	editor_h = 400;
	
	editor_selected_y = buttonHeight + 2*buffer + ebh;
	editor_selected_x = buffer;
	
	initEditorDraggable();
	
}