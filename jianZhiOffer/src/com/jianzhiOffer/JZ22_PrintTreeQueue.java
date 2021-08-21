package com.jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JZ22_PrintTreeQueue {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> array = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return array;
        }
        queue.add(root);
        TreeNode t = new TreeNode(0);
        while(!queue.isEmpty()){
            t = queue.poll();
            array.add(t.val);
            if(t.left!=null){
                queue.add(t.left);
            }
            if(t.right!=null){
                queue.add(t.right);
            }
        }
        return array;

    }
}
