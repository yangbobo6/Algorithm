package com.jianzhiOffer;

//青蛙跳台阶问题   递归解答
public class JZ8_RecursionFrog {
    public int jumpFloor(int target) {
        if(target<=0){
            return -1;
        }else if(target ==1){
            return 1;
        }else if(target ==2){
            return 2;
        }else{
            return jumpFloor(target-1)+jumpFloor(target-2);
        }
    }
}


