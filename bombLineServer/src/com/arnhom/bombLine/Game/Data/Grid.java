package com.arnhom.bombLine.Game.Data;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.lang.reflect.Array;
import java.util.Iterator;

public class Grid<T>  {

    private ixy size;
    private int length;
    private T[] data;
    private T initialValue;

    public Grid(int width, int height, T initialValue){
        this.initialValue = initialValue;
        init(width,height, initialValue);
    }

    public int getWidth(){
        return size.getX();
    }

    public int getHeight(){
        return size.getY();
    }

    private void init(int width, int height, T fill){
        size = new ixy(width,height);
        length = width*height;
        data = (T[])Array.newInstance(fill.getClass(),length);
        fillData(fill);
    }

    public void setData(T[] data){
        this.data = data;
    }

    public T[] getData(){
        return data;
    }

    private void fillData(T n){
        for(int i =0; i < length; i++){
            data[i] = n;
        }
    }

    private boolean posWithinGrid(ixy pos){
        return pos.x >= 0 && pos.x < size.x && pos.y >= 0 && pos.y < size.y;
    }

    private int posToIndex(ixy pos) throws IndexOutOfBoundsException{
        if(posWithinGrid(pos)) {
            return pos.getY() * size.getX() + pos.getX();
        }
        throw new IndexOutOfBoundsException();
    }

    private ixy indexToPos(int index){
        int x = index % size.getX();
        int y = index / size.getX();
        return new ixy(x,y);
    }

    public T get(ixy pos) throws IndexOutOfBoundsException{
        return data[posToIndex(pos)];
    }

    public T set(ixy pos, T value){
        data[posToIndex(pos)] = value;
        return value;
    }

    public boolean hasAValue(ixy pos){
        T value = initialValue;
        try{
            value = this.get(pos);
        }
        catch(IndexOutOfBoundsException ignore){};
        return value != initialValue;
    }
}
