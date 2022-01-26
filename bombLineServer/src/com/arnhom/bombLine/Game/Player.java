package com.arnhom.bombLine.Game;

import com.arnhom.bombLine.Game.Data.fxy;
import com.arnhom.bombLine.Utility.Guid;

public class Player {
    private String name;
    private String id;

    private fxy pos;
    private fxy velocity;

    private float speed;
    private int maxBomb;
    private int blastSize;
    private int blastTime;
    private int fuseTime;
    private boolean canKick;

    public Player(){
        name = generateDefaultName();
        id = generateId();
        initStats();
    }

    private String generateDefaultName(){
        return "bill" + Guid.generate();
    }

    private String generateId(){
        return "pid_" + Guid.generate();
    }

    private void initStats(){
        speed = 1.0f;
        maxBomb = 1;
        blastSize = 3;
        blastTime = 30;
        fuseTime = 2*60;
        canKick = false;
    }


    public void setName(String name){
        this.name = name;
    }
}
