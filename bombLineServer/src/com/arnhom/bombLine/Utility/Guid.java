package com.arnhom.bombLine.Utility;

import java.util.Random;

public class Guid {
    private static Random rand = new Random();
    private static String chars = "abcdefghjijklmnopqrstuvwxyz1234567890!@#$%^&&*()";

    public static String generate(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10;i++){
            sb.append(chars.charAt( rand.nextInt(chars.length()) ));
        }
        return sb.toString();
    }

}
