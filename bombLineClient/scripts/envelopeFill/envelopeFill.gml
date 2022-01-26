// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function envelopeFill(type,obj){
	// cid should probably come from some global value
	
	var env = {
			type: type,
			json: json_stringify(obj),
			cid: getConnectionID()
	}
	return json_stringify(env);
}