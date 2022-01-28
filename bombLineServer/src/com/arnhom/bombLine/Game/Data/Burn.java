package com.arnhom.bombLine.Game.Data;

public class Burn {
    public Integer nextValue;
    public ixy pos;
    public Burn(ixy pos, Integer nextValue){
        this.nextValue = nextValue;
        this.pos = pos;
    }
}
