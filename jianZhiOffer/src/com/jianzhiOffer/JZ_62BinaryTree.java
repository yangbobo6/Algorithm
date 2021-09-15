package com.jianzhiOffer;

import java.util.ArrayList;

//注意数组越界问题   边界值 / 越界
public class JZ_62BinaryTree {
    ArrayList<TreeNode> list = new ArrayList<>();
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot==null||k<=0){
            return null;
        }
        TreeNode treeNode;
        TraverBinaryTree(pRoot);
        if(k>list.size()){
            return null;
        }

        treeNode = list.get(k-1);
        return treeNode;

    }

    public void TraverBinaryTree(TreeNode pRoot){
        if(pRoot!=null){
            TraverBinaryTree(pRoot.left);
            list.add(pRoot);
            TraverBinaryTree(pRoot.right);
        }

    }
}
