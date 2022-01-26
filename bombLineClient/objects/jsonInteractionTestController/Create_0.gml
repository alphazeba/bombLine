/// @description Insert description here
// You can write your code in this editor

var jsonString = readInEntireFile("/Users/arnhom/Projects/eco2/test.json");
show_debug_message(jsonString);

show_debug_message("finsihed reading in the file and printing it to the console");

// now try to parse teh data 
var json = json_parse(jsonString);

json.number += 1;

saveOverwriteStringToFile("/Users/arnhom/Projects/eco2/testOutput.json", json_stringify(json));

