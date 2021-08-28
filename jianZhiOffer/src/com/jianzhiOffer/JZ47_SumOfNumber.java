package com.jianzhiOffer;

public class JZ47_SumOfNumber {
    //对于 前n项和  正常方法利用递归
    int sum = 0;
    public int Sum_Solution1(int n) {
        if(n==1){
            return n;
        }
        else{
            return n+Sum_Solution1(n-1);
        }
    }

    //当不用递归的时候，   可以利用&&  n>0时，满足此体条件才能运行下一个条件
    public int Sum_Solution(int n){
        int sum = n;
        boolean ans = n>0&&(sum+=Sum_Solution(n-1))>0;
        return sum;
    }



    public static void main(String[] args) {
        JZ47_SumOfNumber jz47_sumOfNumber = new JZ47_SumOfNumber();
        System.out.println(jz47_sumOfNumber.Sum_Solution1(10));
    }
}
