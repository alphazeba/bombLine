package com.arnhom.bombLine.Game;

import com.arnhom.bombLine.Network.TransferPOJO.GameObjectPojo;
import com.arnhom.bombLine.Utility.Guid;

public abstract class GameObject {

    private String id;
    protected String type;
    protected boolean active;
    protected boolean removeObject;

    public GameObject(){
        id = generateId();
        removeObject = false;
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

    public void deleteObject(){
        this.removeObject = true;
    }
}
