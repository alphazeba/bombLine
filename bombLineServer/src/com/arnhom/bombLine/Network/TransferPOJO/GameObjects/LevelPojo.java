package com.arnhom.bombLine.Network.TransferPOJO.GameObjects;

import com.arnhom.bombLine.Game.Data.fxy;

public class LevelPojo {
    public int width;
    public int height;

    public Integer[] boxes;
    public fxy[] sl;

    public static LevelPojo buildDefault(){
        LevelPojo pojo = new LevelPojo();
        pojo.width = 5;
        pojo.height = 5;
        pojo.sl = new fxy[]{
                new fxy(1,1),
                new fxy(4,0),
                new fxy(0,2),
                new fxy(4,2)
        };

        pojo.boxes = new Integer[]{
                 0, 0, 0, 0, 0,
                 0, 0, 1, 1, 1,
                 0, 0, 0, 0, 0,
                 1, 1, 1, 1, 1,
                -1,-1,-1,-1,-1
        };
        return pojo;
    }
}
