package com.jianzhiOffer;

import java.util.HashSet;

public class Practice {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(null);
        boolean b = set.add(null);
        set.add(1);
        set.add(2);
        System.out.println(b);
        for (Integer e: set
             ) {
            System.out.println(e);
        }
    }

}
