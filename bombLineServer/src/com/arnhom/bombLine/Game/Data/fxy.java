package com.arnhom.bombLine.Game.Data;

public class fxy {
    public float x;
    public float y;

    public fxy(float x, float y){
        this.x= x;
        this.y =y;
    }

    public fxy multiply(float number){
        return new fxy(x*number, y*number);
    }

    public fxy add(fxy other){
        return new fxy(x+other.x, y+ other.y);
    }
}
