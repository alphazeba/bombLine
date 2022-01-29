// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function readInEntireFile(filter,fname){
	
	
	var accessibleFileName = get_open_filename(filter, fname );
	
	var file = file_text_open_read(accessibleFileName);
	
	var fileContents = "";
	var line = "";
	while(!file_text_eof(file)){
		line = file_text_readln(file);
		fileContents += line;
	}
	file_text_close(file);
	return fileContents;
}