package com.arnhom.bombLine.Game.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Updates {
    private Map<String, Vector<Update>> updateLists;

    public Updates(){
        updateLists = new HashMap<>();
    }

    public void add(String objectId, String key, float value){
        add(objectId,key, Float.toString(value));
    }

    public void add(String objectId, String key, String value){
        add(objectId,new Update(key,value));
    }

    public void add(String objectId, Update update){
        Vector<Update> list = getCreateUpdateList(objectId);
        list.add(update);
    }

    public void add(String objectId, Vector<Update> updateList){
        Vector<Update> myList = getCreateUpdateList(objectId);
        myList.addAll(updateList);
    }

    public void add(Updates other){
        for(String objectId: other.updateLists.keySet()){
            add(objectId, other.updateLists.get(objectId));
        }
    }

    private Vector<Update> getCreateUpdateList(String key){
        if (updateLists.containsKey(key)) {
            return updateLists.get(key);
        }
        Vector<Update> newList = new Vector<>();
        updateLists.put(key,newList);
        return newList;
    }

    private class Update{
        public String k;
        public String v;
        public Update(String key, String value){
            k = key;
            v = value;
        }
    }
}
