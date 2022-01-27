package com.arnhom.bombLine.Game;

import com.arnhom.bombLine.Game.Data.fxy;
import com.arnhom.bombLine.Network.TransferPOJO.GameObjects.BombPojo;

public class Bomb extends GameObject{

    private Player owner;

    private fxy pos;
    private fxy velocity;

    private int blastSize;
    private int blastTime;
    private int fuseTime;

    public Bomb(Player owner,fxy pos,int blastSize, int blastTime, int fuseTime){
        type = "bomb";
        this.owner = owner;

        this.pos = pos.snap();
        this.velocity = new fxy(0,0);

        this.blastSize = blastSize;
        this.blastTime = blastTime;
        this.fuseTime = fuseTime;
    }

    @Override
    public void update() {
        fuseTime--;
        if(fuseTime < 0){
            deleteObject();
        }
    }

    @Override
    public Object getPojo() {
        BombPojo pojo = new BombPojo();
        fillGameObjectPojo(pojo);
        pojo.x = pos.x;
        pojo.y = pos.y;
        pojo.vx = velocity.x;
        pojo.vy = velocity.y;
        pojo.blastSize = blastSize;
        pojo.blastTime = blastTime;
        pojo.fuseTime = fuseTime;
        return pojo;
    }

    public void onDelete(){
        // TODO, need to notify the player that it can increase its bombs again.
        owner.notifyOfOwnedBombsExplosion();
        owner = null;
        //create the fire
        Fire fire = new Fire(this.pos,blastSize,blastTime);
        storeObject(fire);
    }
}
