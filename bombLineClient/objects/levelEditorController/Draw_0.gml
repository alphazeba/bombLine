/// @description Insert description here
// You can write your code in this editor
drawLevel();


// draw the level area
draw_set_color(c_green)
draw_rectangle(0,0, width*64,height*64, true);

// draw the spawnLocations

for(var i =0;i< array_length(spawnLocations); i++){
	var spawnLocation = spawnLocations[i];
	var sx = spawnLocationGetX(spawnLocation);
	var sy = spawnLocationGetY(spawnLocation);
	
	draw_sprite(spr_spawnLocation,0,sx*64, sy*64);
}


drawEditorUi(editor_ox, editor_oy);

draw_set_color(c_white);
draw_text(0,0,instruction);