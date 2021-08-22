package com.jianzhiOffer;

import java.util.ArrayList;

//顺时针打印数组  *************************************************************

public class JZ19_PrintArray {

    //方便定位
    int index = 0;

    //int [][] matrix = {{1,2,3,4,5,6},{6,7,8,9,10,6},{11,12,13,14,15,16}};
    //int [][] matrix ={{1,2,3,4}};
    int [][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15},{16,17,18}};
    //int [][] matrix = {{1,2},{3,4}};


    int row = matrix.length;
    int column = matrix[0].length;
    //需要进行循环的次数
    int count = ((row+1)/2)>((column+1)/2)?((column+1)/2):((row+1)/2);
    ArrayList<Integer> arrayList = new ArrayList<>();

    //打印一个圈的方法
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        //打印第一行
        for (int i = index; i < column-index; i++) {
            arrayList.add(matrix[index][i]);
        }
        for (int j = index+1; j < row-index; j++) {
            arrayList.add(matrix[j][column-index-1]);
        }

        //重点   *****   w  和   h的值  是用来卡剩下最后一行的，不能回头存入
        int h = row - index*2;
        if(h>1){
            for (int i = column-index-2; i >= index ; i--) {
                arrayList.add(matrix[row-index-1][i]);
            }
        }
        //重点  *****
        int w = column - index*2;
        if(w>1){
            for (int j = row-index-2; j > index; j--) {
                arrayList.add(matrix[j][index]);
            }
        }
        index++;
        return arrayList;
    }

    //循环进入的次数   count控制
    public void print(){
        while (count!=0){
            count--;
            printMatrix(matrix);
        }
    }

    public static void main(String[] args) {
        JZ19_PrintArray jz19_printArray = new JZ19_PrintArray();
        jz19_printArray.print();
        for (Integer a : jz19_printArray.arrayList
             ) {
            System.out.println(a);
        }
    }
}
