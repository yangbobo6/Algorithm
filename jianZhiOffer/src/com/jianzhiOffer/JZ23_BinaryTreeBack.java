package com.jianzhiOffer;

public class JZ23_BinaryTreeBack {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0) {
            return false;//排除长度是0的数组
        }
        return check(sequence, 0, sequence.length-1);//sequence.length-1为数组下标末尾  0是数组开头，首次比对
    }

    public boolean check(int[] sequence, int left, int right) {
        if(left >= right) {
            return true;//左边数据大于等于右边，遍历完了获取最小下标，该位置的数第一次大于根树
        }
        int pivot = sequence[right];//中间的根数
        int i = left;//第一次是0
        while(i < right && sequence[i] < pivot) {
            i++;//遍历左子树小于根数，获取最大的数组下标（小于根数），最后获得的数下标大1
        }
        for(int j = i; j < right; j++) {
            if(sequence[j] <= pivot) {
                return false;//判断右子树是否大于根数，不是则错
            }
        }
        return check(sequence, left, i-1) && check(sequence, i, right-1);//递归分别检查遍历 根数的右子树和左子树是否符合要求

    }

}
