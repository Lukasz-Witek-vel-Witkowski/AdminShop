package com.example.lukasz_2.kurierai.Tools;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TranslatorfromImage {
    List<String> Tab;
   final int maxSize = 100;
    int Loop;
    int position;
    public TranslatorfromImage (byte b []){
        if(b!=null) {
            Tab = new LinkedList<>();
            int size = b.length;
            Loop = (int) size / 100;
            String temp = "";
            position = 0;
            for (int i = 0; i < size; i++) {
                temp += b[i];
                if (i > 0 && i%100 == 0) {
                    Tab.add(temp);
                    temp = "";
                    //position++;
                }
            }
        }
    }
    public int getsize(){return Tab.size();}
    public int getposition(){return position;}
    public boolean isNext(){
        if(Loop>position) return true;
        return false;
    }
    public String Next(){
        if(isNext()){
            position++;
        return Tab.get(position-1);
        }
        return null;
    }
}
