/// @description Insert description here
// You can write your code in this editor
var box = 64;
var offsets = [
	[0,-box],
	[box,0],
	[0,box],
	[-box,0]
]

var spr = spr_fire;

draw_sprite(spr,0,x,y);

for(var oi =0;oi < array_length(offsets); oi++){
	var length = explosion[oi];
	var curOffset = offsets[oi];
	for(var i =1;i<length+1;i++){
		draw_sprite(spr,0,x+curOffset[0]*i,y+curOffset[1]*i);
	}
}