package com.arnhom.bombLine.Game;

import com.arnhom.bombLine.Network.TransferPOJO.StatePojo;

import java.util.*;

public class World {

    private Map<String, GameObject> objects;
    private Vector<Player> players; // these are also stored in the objects.

    private Vector<GameObject> newObjects;


    public World(){
        objects = new HashMap<>();
        players = new Vector<>();
        newObjects = new Vector<>();
    }

    public StatePojo update() throws Exception {
        Set<String> keys = objects.keySet();

        // handle updates
        for(String key: keys){
            objects.get(key).update();
        }

        // upkeep
        // build the resulting state, mark the objects to remove, and call onDelete
        Vector<Object> state = new Vector<>();
        Vector<String> deadIds = new Vector<>();
        for(String key: keys){
            GameObject obj = objects.get(key);
            state.add(obj.getPojo());
            if(obj.shouldBeRemoved()){
                obj.onDelete();
                deadIds.add(key);
            }
        }

        // filter out the removed objects.
        for(String deadId: deadIds){
            objects.remove(deadId);
        }

        // add in the new objects
        for(GameObject obj: newObjects){
            objects.put(obj.getId(), obj);
        }
        newObjects = new Vector<>();

        return new StatePojo(state,deadIds);
    }

    public Player requestPlayer(String connectionId){
        for(Player player: players){
            if(player.getConnectionId().equals(connectionId)){
                return player;
            }
        }

        // else we need to create a new player.
        return createNewPlayer(connectionId);
    }

    public Player createNewPlayer(String connectionId){
        Player newPlayer = new Player(connectionId);
        storeObject(newPlayer);
        players.add(newPlayer);
        return newPlayer;
    }

    public void storeObject(GameObject obj){
        newObjects.add(obj);
        obj.setObjectCreator(this);
    }
}
