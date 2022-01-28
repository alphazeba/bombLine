package com.arnhom.bombLine.Game;

import com.arnhom.bombLine.Game.Data.fxy;
import com.arnhom.bombLine.Network.TransferPOJO.GameObjects.PlayerPojo;
import com.arnhom.bombLine.Utility.Guid;

public class Player extends GameObject{
    private String name;
    private int style;

    private String connectionId;

    private fxy velocity;

    private fxy moveIntent;
    private boolean bombIntent;

    private float speed;
    private int maxBomb;
    private int blastSize;
    private int blastTime;
    private int fuseTime;
    private boolean canKick;

    private int numBombsActive;

    public Player(String connectionId, int style){
        super();
        name = generateDefaultName();
        type = "player";
        this.style = style;
        this.connectionId = connectionId;
        initialize();
    }

    public String getConnectionId(){
        return connectionId;
    }

    public void intendMove(fxy movement){
        moveIntent = movement;
    }

    public void intendToBomb(){
        bombIntent = true;
    }

    public void initialize(){
        super.initialize();
        velocity = new fxy(0,0);

        moveIntent = new fxy(0,0);
        bombIntent = false;

        speed = 0.1f;
        maxBomb = 1;
        blastSize = 2;
        blastTime = 30;
        fuseTime = 2*60;
        canKick = false;

        numBombsActive = 0;
    }

    @Override
    public void update() {
        // handle player input
        if(bombIntent){
            bombIntent = false;

            if(numBombsActive < maxBomb){
                Bomb newBomb = new Bomb(this,this.pos,blastSize,blastTime,fuseTime);
                storeObject(newBomb);
                numBombsActive += 1;
            }
        }
        velocity = moveIntent.multiply(speed);

        // check collision
        fxy futurePos = pos.add(velocity);
        if(world.collisionPlayer(futurePos)){
            // try moving half the distance
            futurePos = pos.add(velocity.multiply(0.5f));
            if(world.collisionPlayer(futurePos)){
                futurePos = pos;
            }
        }

        // apply the new position
        pos = futurePos;

    }

    public void notifyOfOwnedBombsExplosion(){
        numBombsActive = Math.max(0, numBombsActive-1);
    }

    private String generateDefaultName(){
        return "bill" + Guid.generate();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public PlayerPojo getPojo(){
        PlayerPojo pojo = new PlayerPojo();
        fillGameObjectPojo(pojo);
        pojo.name = name;
        pojo.x = pos.x;
        pojo.y = pos.y;
        pojo.vx = velocity.x;
        pojo.vy = velocity.y;
        pojo.speed = speed;
        pojo.maxBomb = maxBomb;
        pojo.blastSize = blastSize;
        pojo.blastTime = blastTime;
        pojo.fuseTime = fuseTime;
        pojo.canKick = canKick;
        pojo.style = style;
        return pojo;
    }

    public boolean hurtable(){
        return active;
    }

    public void hurt(){
        active = false;
    }

    public void onDelete() throws Exception {
        throw new Exception("no! a player object should never be deleted.");
    }
}
