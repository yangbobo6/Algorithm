package com.jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

//-1只是退出循环的标志
public class JZ39_IsBalance {
    boolean isBalance = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null){
            return true;
        }
        DeepOfTree(root);
        return isBalance;
    }
    public int DeepOfTree(TreeNode root){
        if(root==null){
            return 0;
        }
        int l = DeepOfTree(root.left);
        if(l==-1){
            return -1;
        }
        int r = DeepOfTree(root.right);
        if(r==-1){
            return -1;
        }
        if(Math.abs(l-r)>1){
            isBalance = false;
            return -1;
        }
        return Math.max(l,r)+1;
    }
}
