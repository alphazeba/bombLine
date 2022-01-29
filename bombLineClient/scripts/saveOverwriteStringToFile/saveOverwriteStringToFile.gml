// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function saveOverwriteStringToFile(dataString,filter,fname){
	var accessibleFileName = get_save_filename(filter,fname);
	
	var file = file_text_open_write(accessibleFileName);
	
	file_text_write_string(file, dataString);
	
	file_text_close(file);
}