// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
function notifyIntentUpdate(moveIntent,dropBomb){
	var intentBlob = {
		move: moveIntent,
		dropBomb: dropBomb
	}
	with(networkingController){
		networkSendString( clientSocket, requestSendIntent(intentBlob) );	
	}
}