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

    public fxy subtract(fxy other){
        return new fxy(x-other.x, y-other.y);
    }

    public fxy snap() {
        return new fxy((float)Math.floor(x), (float)Math.floor(y));
    }

    public ixy snapToIxy(){
        fxy snapped = this.snap();
        return new ixy((int)snapped.x, (int)snapped.y);
    }
}
