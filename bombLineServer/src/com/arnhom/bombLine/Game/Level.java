package com.arnhom.bombLine.Game;

import com.arnhom.bombLine.Game.Data.Burn;
import com.arnhom.bombLine.Game.Data.Grid;
import com.arnhom.bombLine.Game.Data.fxy;
import com.arnhom.bombLine.Game.Data.ixy;
import com.arnhom.bombLine.Game.WorldAssistance.RangeDoler;
import com.arnhom.bombLine.Network.TransferPOJO.GameObjects.LevelPojo;

import java.util.Vector;

public class Level {

    private Grid<Integer> boxes;
    private fxy[] spawnLocations;
    private Vector<Burn> burns;
    private RangeDoler spawnDoler;

    public Level(LevelPojo levelData){
        initialize(levelData);
    }

    public void placePlayer(Player player){
        fxy spawnLocation = spawnLocations[spawnDoler.getNext()];
        player.setPos(spawnLocation.add(new fxy(0.5f,0.5f)));
    }

    private void initialize(LevelPojo levelData){
        burns = new Vector<>();
        loadLevel(levelData);
    }

    public boolean handlePlayerCollision(fxy playerPos){
        fxy playerSnapped = playerPos.snap();
        ixy playerBox = playerSnapped.snapToIxy();
        if(playerCollidableHere(playerBox)){
            return true;
        }

        fxy delta = playerPos.subtract(playerSnapped);
        float radius = 0.15f;
        // check radius of edges
        if(delta.x < radius){ // left
            if(playerCollidableHere(playerBox.add(-1,0))){
                return true;
            }
        }
        if(delta.x > 1.f-radius){ // right
            if(playerCollidableHere(playerBox.add(1,0))){
                return true;
            }
        }
        if(delta.y < radius){ // above
            if(playerCollidableHere(playerBox.add(0,-1))){
                return true;
            }
        }
        if(delta.y > 1.f-radius){ // below
            if(playerCollidableHere(playerBox.add(0,1))){
                return true;
            }
        }
        // TODO handle the corners.
        return false;
    }

    public boolean handleFireCollision(ixy firePos){
        if(fireCollidableHere(firePos)){
            handleBurn(firePos);
            return true;
        }
        return false;
    }

    private boolean playerCollidableHere(ixy pos){
        return boxes.hasAValue(pos);
    }

    private boolean fireCollidableHere(ixy pos){
        return boxes.hasAValue(pos);
    }

    private void handleBurn(ixy pos){
        Integer value = boxes.get(pos);
        if(value != -1){
            boxes.set(pos,-1);
            burns.add(new Burn(pos,value-1));
        }
    }

    public void afterUpdateCleanup(){
        for(Burn burn: burns){
            boxes.set(burn.pos,burn.nextValue);
        }
        burns = new Vector<>();
    }

    public LevelPojo getPojo() {
        LevelPojo pojo = new LevelPojo();
        pojo.width = boxes.getWidth();
        pojo.height = boxes.getHeight();
        pojo.boxes = boxes.getData();
        return pojo;
    }
    public void loadLevel(LevelPojo pojo){
        boxes = new Grid<>(pojo.width,pojo.height,0);
        boxes.setData(pojo.boxes.clone());
        spawnLocations = pojo.sl;
        spawnDoler = new RangeDoler(spawnLocations.length);
    }

}
