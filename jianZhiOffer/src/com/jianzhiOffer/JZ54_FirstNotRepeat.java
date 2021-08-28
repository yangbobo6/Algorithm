package com.jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

public class JZ54_FirstNotRepeat {
    int[] map = new int[256];
    Queue<Character> chars = new LinkedList<Character>();


    //Insert one char from stringstream
    public void Insert(char ch) {
        if(map[ch]==0){
            map[ch]=1;
            chars.offer(ch);
        }
        else if(map[ch]==1){
            map[ch]=-1;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while (!chars.isEmpty()&&map[chars.peek()]==-1){
            chars.poll();
        }
        if(!chars.isEmpty()){
            return chars.poll();
        }
        return '#';
    }
}
