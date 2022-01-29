package com.arnhom.bombLine.Game.SpecificObjects;

import com.arnhom.bombLine.Game.Data.fxy;
import com.arnhom.bombLine.Game.Data.ixy;
import com.arnhom.bombLine.Game.GameObject;
import com.arnhom.bombLine.Network.TransferPOJO.GameObjects.FirePojo;

public class Fire extends GameObject {
    int blastSize;
    int blastTime;
    int[] explosion;


    public static final String typeFire = "fire";

    public Fire(fxy pos, int blastSize,int blastTime){
        super();
        this.type = typeFire;
        this.pos = pos.snap();
        this.blastSize = blastSize;
        this.blastTime = blastTime;
    }

    @Override
    public void onSpawn(){
        doExplosion();
    }

    @Override
    public void update() {
        doFireHurt();

        blastTime--;
        if(blastTime < 0){
            deleteObject();
        }
    }

    private static final ixy[] directions = new ixy[]{
            new ixy(0,-1),
            new ixy(1,0),
        new ixy(0,1),
        new ixy(-1,0)
    };

    public void doExplosion(){
        explosion = new int[4];
        for(int di = 0;di<directions.length;di++){
            ixy direction = directions[di];
            ixy checkingPos = pos.snapToIxy();
            explosion[di] = blastSize;
            for(int i=0; i < blastSize; i++){
                checkingPos = checkingPos.add(direction);
                if(world.fireLevelCollision(checkingPos)){
                    explosion[di] = i+1;
                    break;
                }
            }
        }
    }

    private void doFireHurt(){
        ixy firePos = pos.snapToIxy();
        world.fireHurtCollision(firePos);
        for(int di = 0;di<directions.length;di++){
            ixy direction = directions[di];
            ixy checkingPos = firePos;
            for(int i=0; i < explosion[di]; i++){
                checkingPos = checkingPos.add(direction);
                world.fireHurtCollision(checkingPos);
            }
        }
    }

    @Override
    public Object getPojo() {
        FirePojo pojo = new FirePojo();
        fillGameObjectPojo(pojo);
        pojo.x = pos.x;
        pojo.y = pos.y;
        pojo.exp = explosion;
        pojo.blastTime = blastTime;
        return pojo;
    }

}
