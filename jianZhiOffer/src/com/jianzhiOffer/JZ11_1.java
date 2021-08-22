package com.jianzhiOffer;

public class JZ11_1 {
    public int NumberOf1(int n) {
        int cnt = 0;
        // 循环直到n == 0
        while(n != 0){
            // 判断 n & 1 是否为0
            if((n & 1)!=0)cnt++;
            //将n进行无符号右移
            n = n>>>1;
        }
        return cnt;
    }
}
