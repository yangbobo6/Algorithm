package com.jianzhiOffer;

import java.util.ArrayList;

public class JZ24_NumSum {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //存储树的各个节点值 的和
        int temp = 0;
        int n = target;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root == null){
            return arrayLists;
        }
        Traverse(arrayLists,arrayList,root,temp,n);
        //arrayLists.add(SumNumOfTheTreeNode(root,temp,n));
        return arrayLists;
    }

    //计算本层 二叉树 值的和  与n作比较
    public ArrayList<Integer> SumNumOfTheTreeNode(ArrayList<Integer> arrayList,TreeNode treeNode,int temp, int n){
        //treeNode是存在的
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.addAll(arrayList);
        if(n>=temp){
            arrayList1.add(treeNode.val);
            return arrayList1;
        }else {
            //销毁 arraylist
            return null;
        }
    }

    //遍历二叉树
    public void Traverse(ArrayList<ArrayList<Integer>> arrayLists,ArrayList<Integer> arrayList,TreeNode treeNode, int temp,int n){
        temp = temp + treeNode.val;
        arrayList = SumNumOfTheTreeNode(arrayList,treeNode,temp,n);
        if(n==temp&&treeNode.left==null&&treeNode.right==null){
            arrayLists.add(arrayList);
        }
        if(treeNode.left!=null){
            Traverse(arrayLists,arrayList,treeNode.left,temp,n);
        }
        if(treeNode.right!=null){
            Traverse(arrayLists,arrayList,treeNode.right,temp,n);
        }
    }
}

