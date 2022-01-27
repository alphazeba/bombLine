/// @description Insert description here
// You can write your code in this editor
var box = 64;
var offsets = [
	[box,0],
	[-box,0],
	[0,box],
	[0,-box]
]

var spr = spr_fire;

draw_sprite(spr,0,x,y);

for(var i =1;i< blastSize; i++){
	for(var j=0;j<array_length(offsets); j++){
		var curOffset = offsets[j];
		draw_sprite(spr,0,x+curOffset[0]*i,y+curOffset[1]*i);
	}
}