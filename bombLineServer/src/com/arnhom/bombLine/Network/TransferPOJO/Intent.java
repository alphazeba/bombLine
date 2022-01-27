package com.arnhom.bombLine.Network.TransferPOJO;

import com.arnhom.bombLine.Game.Data.fxy;

public class Intent {

    private static final String validMove = "qweasdzxc";
    private static final float h = 0.5f;
    private static final fxy[] vectors = {
            new fxy(-h,-h),
            new fxy(0,-1),
            new fxy(h,-h),

            new fxy(-1,0),
            new fxy(0,0),
            new fxy(1, 0),

            new fxy(-h,h),
            new fxy(0,1),
            new fxy(h,h)
    };

    public char move;
    /*
    q w e
    a s d
    z x c
     s is no movement.
    */
    public boolean dropBomb;

    public fxy getVector(){
        int lookupIndex = validMove.indexOf(move);
        if(lookupIndex < 0){
            lookupIndex = validMove.indexOf('s');
        }
        return vectors[lookupIndex];
    }
}
