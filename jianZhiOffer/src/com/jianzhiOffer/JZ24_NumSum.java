package com.jianzhiOffer;

import java.util.ArrayList;

public class JZ24_NumSum {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //存储树的各个节点值 的和
        int temp = 0;
        int n = target;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(root == null){
            return null;
        }
        Traverse(arrayLists,root,temp,n);
        //arrayLists.add(SumNumOfTheTreeNode(root,temp,n));
        return arrayLists;
    }

    //计算本层 二叉树 值的和  与n作比较
    public ArrayList<Integer> SumNumOfTheTreeNode(TreeNode treeNode,int temp, int n){
        //treeNode是存在的
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(n>=temp){
            arrayList.add(treeNode.val);
            return arrayList;
        }else {
            return null;
        }
    }

    //遍历二叉树
    public void Traverse(ArrayList<ArrayList<Integer>> arrayLists,TreeNode treeNode, int temp,int n){
        temp = temp + treeNode.val;
        arrayLists.add(SumNumOfTheTreeNode(treeNode,temp,n));
        if(treeNode.left!=null){
            Traverse(arrayLists,treeNode.left,temp,n);
        }
        if(treeNode.right!=null){
            Traverse(arrayLists,treeNode.right,temp,n);
        }
    }
}

