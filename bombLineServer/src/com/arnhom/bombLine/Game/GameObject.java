package com.arnhom.bombLine.Game;

import com.arnhom.bombLine.Game.Data.fxy;
import com.arnhom.bombLine.Game.SpecificObjects.Player;
import com.arnhom.bombLine.Network.TransferPOJO.GameObjects.GameObjectPojo;
import com.arnhom.bombLine.Utility.Guid;

public abstract class GameObject {

    protected World world;

    private String id;
    private boolean removeObject;

    protected String type;
    protected boolean active;
    protected fxy pos;


    public GameObject(){
        id = generateId();
        initialize();
    }

    public void initialize(){
        pos = new fxy(0,0);
        removeObject = false;
        active = true;
    }

    public boolean shouldBeRemoved(){
        return removeObject;
    }

    private String generateId(){
        return "pid_" + Guid.generate();
    }

    public String getId(){
        return id;
    }

    public void setPos(fxy pos){
        this.pos = pos;
    }

    public fxy getPos(){
        return pos;
    }

    public void onSpawn(){

    }

    public abstract void update();

    public void upkeep(){

    }

    public void onDelete() throws Exception {

    }

    public void fillGameObjectPojo(GameObjectPojo pojo){
        pojo.oid = id;
        pojo.type = type;
        pojo.active = active;
        pojo.x = pos.x;
        pojo.y = pos.y;
    }

    public abstract Object getPojo();

    public void setObjectCreator(World world){
        this.world = world;
        onSpawn();
    }

    public void storeObject(GameObject obj){
        world.storeObject(obj);
    }

    public void deleteObject(){
        this.removeObject = true;
    }

    public boolean hurtable(){
        return active;
    }

    public void hurt(){

    }
}
