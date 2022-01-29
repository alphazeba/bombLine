package com.arnhom.bombLine.Game.SpecificObjects;

import com.arnhom.bombLine.Game.Data.fxy;
import com.arnhom.bombLine.Game.GameObject;
import com.arnhom.bombLine.Network.TransferPOJO.GameObjects.BombPojo;

import java.util.*;

public class Bomb extends GameObject {

    private Player owner;

    private fxy velocity;

    private int blastSize;
    private int blastTime;
    private int fuseTime;

    private boolean dud;

    private Set<String> dontCollideList;

    public static final String typeBomb = "bomb";
    public static final float collisionRadius = 0.4f;

    public Bomb(Player owner,fxy pos,int blastSize, int blastTime, int fuseTime){
        super();
        type = typeBomb;
        this.owner = owner;

        this.pos = pos.snap().add(new fxy(0.5f,0.5f));
        this.velocity = new fxy(0,0);

        this.blastSize = blastSize;
        this.blastTime = blastTime;
        this.fuseTime = fuseTime;

        dud = false;
    }

    private Set<String> buildInitialDontCollideList(){
        List<Player> collidingPlayers = world.getListOfPlayersTouchingBomb(pos);
        Set<String> collidingIds = new HashSet<>();
        for(Player player: collidingPlayers){
            collidingIds.add(player.getId());
        }
        return collidingIds;
    }

    private Set<String> upkeepDontCollideList(){
        if(dontCollideList.isEmpty()){ // no need to maintain if there is already nothing in the list.
            return dontCollideList;
        }

        List<Player> collidingPlayers = world.getListOfPlayersTouchingBomb(pos);
        Set<String> newDontCollideList = new HashSet<>();
        for(Player player: collidingPlayers){
            String id = player.getId();
            if( dontCollideList.contains(id) ){
                newDontCollideList.add(id);
            }
        }
        return newDontCollideList;
    }

    public boolean canCollideWithPlayer(Player player){
        return ! dontCollideList.contains( player.getId() );
    }

    @Override
    public void onSpawn(){
        if(world.bombBombCollision(pos)){
            // turn this bomb into a dud and kill it.
            dud =true;
            deleteObject();
        }
        dontCollideList = buildInitialDontCollideList();
    }

    @Override
    public void update() {
        fuseTime--;
        if(fuseTime < 0){
            deleteObject();
        }
    }

    @Override
    public void upkeep(){
        // maybe i can handle the tests as to whether the collision has happened here.
        dontCollideList = upkeepDontCollideList();
    }

    public void onDelete(){
        // TODO, need to notify the player that it can increase its bombs again.
        owner.notifyOfOwnedBombsDeletion();
        owner = null;
        //create the fire
        if(!dud){
            Fire fire = new Fire(this.pos,blastSize,blastTime);
            storeObject(fire);
        }
    }

    public void hurt(){
        deleteObject();
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


}
