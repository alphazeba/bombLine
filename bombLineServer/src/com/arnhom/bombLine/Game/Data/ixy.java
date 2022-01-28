package com.arnhom.bombLine.Game.Data;

public class ixy {
    public int x;
    public int y;

    public ixy(int x, int y){
        this.x= x;
        this.y =y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public ixy multiply(int number){
        return new ixy(x*number, y*number);
    }

    public ixy add(ixy other){
        return new ixy(x+other.x, y+ other.y);
    }
    public ixy add(int x, int y){
        return new ixy(this.x + x, this.y + y);
    }

    public boolean equals(ixy other){
        return x==other.x && y == other.y;
    }
}