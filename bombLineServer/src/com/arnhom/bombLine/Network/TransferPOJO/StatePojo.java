package com.arnhom.bombLine.Network.TransferPOJO;

import java.util.List;

public class StatePojo {
    List<Object> objs;
    List<String> deadIds;

    public StatePojo(List<Object> objs, List<String> deadIds){
        this.objs = objs;
        this.deadIds = deadIds;
    }
}
