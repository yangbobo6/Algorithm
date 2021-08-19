package com.jianzhiOffer;

//在二维数组中查找  找值  暴力查找法
public class JZ1_ArrayListSearch {
    public boolean Find(int target, int [][] array) {
        if(array.length == 0||array[0].length==0||array == null){
            return false;
        }
        int rows = array.length; int columns = array[0].length;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<columns;j++){
                if(array[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

    //（时间复杂度底）方法二   从右上角开始找    大于就往下走，小于就往左走，
    public boolean Find1(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int rows = array.length, col = array[0].length;
        //从第0行col - 1列开始查找，也就是第1行最后一列的那个数字开始
        int row = 0;
        int column = col - 1;
        while (row < rows && column >= 0) {
            //num表示当前值
            int num = array[row][column];
            if (num == target) {
                //如果找到直接返回
                return true;
            } else if (num > target) {
                //到前面查找
                column--;
            } else {
                //到下面查找
                row++;
            }
        }
        return false;
    }
}


