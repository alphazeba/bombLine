// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function cleanStringForSending(inputString){
	
	// verify its properly terminated.
	var terminator = "\n";
	var lastChar = string_length(inputString)-1;
	if( string_char_at(inputString,lastChar) != terminator) {
		inputString += terminator;
	}
	
	// TODO, what other things could be wrong with the string?
	
	return inputString;
}