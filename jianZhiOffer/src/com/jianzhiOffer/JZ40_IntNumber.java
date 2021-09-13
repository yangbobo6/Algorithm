package com.jianzhiOffer;

import java.util.*;

public class JZ40_IntNumber {
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        int flag = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int [] list = new int[2];
        for (int i = 0; i < array.length; i++) {
            if(!hashMap.containsKey(array[i])) {
                hashMap.put(array[i], 1);
            }else {
                hashMap.put(array[i],2);
            }
        }
        Set<Map.Entry<Integer,Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Integer,Integer> entry: entries
             ) {
            Integer value = entry.getValue();
            Integer key = entry.getKey();
            if(flag>1){
                break;
            }
            if(value==1){
                list[flag]=key;
                flag++;
            }

        }
        Arrays.stream(list).sorted();
        return list;
    }
}
