package com.arnhom.bombLine.Game;

import com.arnhom.bombLine.Network.TransferPOJO.GameObjects.GameObjectPojo;
import com.arnhom.bombLine.Utility.Guid;

public abstract class GameObject {

    private World world;
    private String id;
    protected String type;
    protected boolean active;
    private boolean removeObject;

    public GameObject(){
        id = generateId();
        removeObject = false;
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

    public abstract void update();

    public void fillGameObjectPojo(GameObjectPojo pojo){
        pojo.oid = id;
        pojo.type = type;
        pojo.active = active;
    }

    public abstract Object getPojo();

    public void onDelete() throws Exception {

    }

    public void setObjectCreator(World world){
        this.world = world;
    }

    public void storeObject(GameObject obj){
        world.storeObject(obj);
    }

    public void deleteObject(){
        this.removeObject = true;
    }
}
