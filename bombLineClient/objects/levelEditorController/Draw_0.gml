/// @description Insert description here
// You can write your code in this editor
drawLevel();


// draw the level area
draw_set_color(c_green)
draw_rectangle(0,0, width*64,height*64, true);


drawEditorUi(editor_ox, editor_oy);

draw_text(0,0,instruction);