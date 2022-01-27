package com.arnhom.bombLine.Game;

import com.arnhom.bombLine.Game.Data.fxy;
import com.arnhom.bombLine.Network.TransferPOJO.GameObjects.BombPojo;
import com.arnhom.bombLine.Network.TransferPOJO.GameObjects.FirePojo;

public class Fire extends GameObject{

    fxy pos;

    int blastSize;
    int blastTime;

    public Fire(fxy pos, int blastSize,int blastTime){
        this.type = "fire";
        this.pos = pos.snap();
        this.blastSize = blastSize;
        this.blastTime = blastTime;
    }

    @Override
    public void update() {
        blastTime--;
        if(blastTime < 0){
            deleteObject();
        }
    }

    @Override
    public Object getPojo() {
        FirePojo pojo = new FirePojo();
        fillGameObjectPojo(pojo);
        pojo.x = pos.x;
        pojo.y = pos.y;
        pojo.blastSize = blastSize;
        pojo.blastTime = blastTime;
        return pojo;
    }

}
