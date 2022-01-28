// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function stringSplit(inputString,splitChar){
	var output = [""];
	var outputSlot = 0;
	for(var i=1;i<string_length(inputString)+1;i++){
		var curChar = string_char_at(inputString,i);
		
		if(curChar == splitChar){
			outputSlot++;
			output[outputSlot] = "";
		}
		else{
			output[outputSlot] += curChar;	
		}
		
	}
	return output;
}