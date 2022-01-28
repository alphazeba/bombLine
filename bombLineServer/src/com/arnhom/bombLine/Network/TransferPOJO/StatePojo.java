package com.arnhom.bombLine.Network.TransferPOJO;

import com.arnhom.bombLine.Network.TransferPOJO.GameObjects.LevelPojo;

import java.util.List;

public class StatePojo {
    List<Object> objs;
    List<String> deadIds;
    LevelPojo level;

    public StatePojo(List<Object> objs, List<String> deadIds,LevelPojo level){
        this.objs = objs;
        this.deadIds = deadIds;
        this.level = level;
    }
}
