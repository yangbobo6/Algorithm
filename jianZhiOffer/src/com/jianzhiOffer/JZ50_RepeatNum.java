package com.jianzhiOffer;

import java.util.HashSet;

public class JZ50_RepeatNum {
    public int duplicate (int[] numbers) {
        // write code here
        HashSet<Integer> hashSet = new HashSet<>();
        int length = numbers.length;
        int temp = 0;
        if(length==0){
            return -1;
        }
        for (int i = 0; i < length; i++) {

            if(hashSet.contains(numbers[i])){
                temp = numbers[i];
                break;
            }
            hashSet.add(numbers[i]);
        }
        return temp;
    }
}
