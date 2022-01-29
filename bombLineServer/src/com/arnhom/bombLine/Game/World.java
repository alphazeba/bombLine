package com.arnhom.bombLine.Game;

import com.arnhom.bombLine.Game.Data.fxy;
import com.arnhom.bombLine.Game.Data.ixy;
import com.arnhom.bombLine.Game.WorldAssistance.RangeDoler;
import com.arnhom.bombLine.Network.TransferPOJO.GameObjects.LevelPojo;
import com.arnhom.bombLine.Network.TransferPOJO.StatePojo;

import java.util.*;

public class World {

    private Map<String, GameObject> objects;
    private Vector<Player> players; // these are also stored in the objects.

    private Vector<GameObject> newObjects;

    private Level level;
    private LevelPojo originalLevelData;

    private RangeDoler styles;

    public World(){
        objects = new HashMap<>();
        players = new Vector<>();
        newObjects = new Vector<>();
        originalLevelData = LevelPojo.buildDefault();
        level = new Level(originalLevelData);
        styles = new RangeDoler(4);
    }

    public void setLevel(LevelPojo levelData){
        originalLevelData = levelData;
        reinitialize();
    }

    public StatePojo reinitialize(){
        // send a message killing all of the objects
        Vector<String> deadIds = new Vector<>( objects.keySet() );

        StatePojo deadState = new StatePojo(new Vector<>(),deadIds,level.getPojo());

        level = new Level(originalLevelData);
        newObjects = new Vector<>();
        objects = new HashMap<>();
        for(Player player: players){
            player.initialize();
            objects.put(player.getId(),player);
            level.placePlayer(player);
        }

        return deadState;
    }

    public boolean collisionPlayer(fxy playerPosition){
        return level.handlePlayerCollision(playerPosition);
    }

    public boolean fireLevelCollision(ixy firePosition){
        return level.handleFireCollision(firePosition);
    }

    public void fireHurtCollision(ixy firePosition){
        for(Player player: players){
            if( player.hurtable() && player.getPos().snapToIxy().equals(firePosition)){
                player.hurt();
            }
        }
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
        level.afterUpdateCleanup();

        // filter out the removed objects.
        for(String deadId: deadIds){
            objects.remove(deadId);
        }

        // add in the new objects
        for(GameObject obj: newObjects){
            objects.put(obj.getId(), obj);
        }
        newObjects = new Vector<>();

        return new StatePojo(state,deadIds,level.getPojo());
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
        Player newPlayer = new Player(connectionId,styles.getNext());
        storeObject(newPlayer);
        players.add(newPlayer);
        level.placePlayer(newPlayer);
        return newPlayer;
    }

    public void storeObject(GameObject obj){
        newObjects.add(obj);
        obj.setObjectCreator(this);
    }
}
