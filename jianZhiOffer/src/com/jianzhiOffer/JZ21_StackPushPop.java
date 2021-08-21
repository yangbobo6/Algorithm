package com.jianzhiOffer;

import java.util.Queue;
import java.util.Stack;


//pushA  和   popA 是两个数组序列，  判断这两个是否符合栈的先进后出次序
//方法  初始化：用指针i指向pushV的第一个位置， 指针j指向popV的第一个位置
//        如果pushV[i] != popV[j]， 那么应该将pushV[i]放入栈中， ++i
//        否则，pushV[i]==popV[j], 说明这个元素是放入栈中立马弹出，所以，++i, ++j，然后应该检查popV[j]
//        与栈顶元素是否相等，如果相等，++j, 并且弹出栈顶元素
//        4，重复2，3， 如果i==pushV.size(), 说明入栈序列访问完，此时检查栈是否为空，如果为空，说明匹配，则不匹配。
public class JZ21_StackPushPop {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length ==0 && popA.length == 0){
            return true;
        }

        Stack<Integer> sta = new Stack<>();
        int i = 0; int j = 0;
        while(i<pushA.length){
            if(pushA[i]!=popA[j]){
                sta.push(pushA[i]);
                i++;
            }
            else{
                i++;
                j++;
                while(!sta.empty() && sta.peek()==popA[j]){
                    sta.pop();
                    j++;
                }
            }
        }
        return sta.empty();

    }
}
