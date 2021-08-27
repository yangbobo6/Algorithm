package com.jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

public class JZ38_DeepTree {
    //计算二叉树的深度   递归方法
    public int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l = TreeDepth(root.left);
        int r = TreeDepth(root.right);
        return Math.max(l,r)+1;
    }


    //队列   层序遍历求值   队列每一层算一次深度
    public int TreeQueueDepth(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null){
            return 0;
        }
        int high = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while(size!=0){
                TreeNode treeNode = queue.poll();
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if (treeNode.right!=null){
                    queue.add(treeNode.right);
                }
                size--;
            }
            high++;
        }
        return high;
    }
}
