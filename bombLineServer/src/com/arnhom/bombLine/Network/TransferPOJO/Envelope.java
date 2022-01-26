package com.arnhom.bombLine.Network.TransferPOJO;

import com.google.gson.Gson;
import com.sun.tools.doclint.Env;
import sun.tools.java.ClassType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.google.gson.Gson;

import static javax.swing.UIManager.put;

public class Envelope {
    static Gson gson = new Gson();
    static public Envelope parseMessage(String message){
        return gson.fromJson(message,Envelope.class);
    }

    private String type;
    private String json;
    public String cid; // connection id

    public <T> T open(Class<T> classType){
        return gson.fromJson(json,classType);
    }

    public Envelope fill(Object obj){
        json = gson.toJson(obj);
        return this;
    }

    public Envelope copy(){
        Envelope copy = new Envelope();
        copy.type = this.type;
        copy.json = this.json;
        copy.cid = this.cid;
        return copy;
    }

    public String toString(){
        return gson.toJson(this);
    }

    public boolean is(String messageType){
        return Objects.equals(type, messageType);
    }
}

