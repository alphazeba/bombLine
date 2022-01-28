package com.arnhom.bombLine.Game.WorldAssistance;

import java.util.*;

public class RangeDoler {
    private Integer[] closet;
    private int stylesGiven;

    public RangeDoler(int numStyles){
        stylesGiven = 0;
        closet = buildCloset(numStyles);
    }

    private Integer[] buildCloset(int numStyles){
        List<Integer> range = new Vector<>();
        for(int i =0;i<numStyles;i++){
            range.add(i);
        }
        Collections.shuffle(range);
        return range.toArray(new Integer[0]);
    }

    public int getNext(){
        int style = closet[stylesGiven % closet.length];
        stylesGiven++;
        return style;
    }
}
