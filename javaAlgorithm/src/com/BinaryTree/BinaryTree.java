package com.BinaryTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

//二叉树的建立和遍历
public class BinaryTree {
    private TreeNode root;
    //构造方法
    public BinaryTree(){}
    public BinaryTree(TreeNode root){
        this.root = root;
    }

    //创建二叉树的方法
    public void buildTree() {
        Scanner scanner = null;
        try {
            //scanner = new Scanner(new File("D:\\test\\input.txt"));
            scanner = new Scanner(new File("D:\\JAVA学习\\Algorithm\\JavaAlgorithm\\src\\com\\BinaryTree\\input.txt"));
            // D:\JAVA学习\Algorithm\JavaAlgorithm\src\com\BinaryTree\input.txt
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        root = creatTree(root, scanner);
    }

    private TreeNode creatTree(TreeNode root,Scanner scanner){
        String temp = scanner.next();
        if(temp.trim().equals("#")){
            return null;
        }else {
            root = new TreeNode(temp);
            //递归生成左子树
            root.setLeft(creatTree(root.getLeft(),scanner));
            //递归生成右子树
            root.setRight(creatTree(root.getRight(),scanner));
            return root;
        }
    }

    public void inOrderTraverse(){
        inOrderTraverse(root);
    }

    //中序遍历   左 根 右
    public void inOrderTraverse(TreeNode root){
        if(root!=null){
            //先遍历左边
            inOrderTraverse(root.getLeft());
            System.out.println(root.getValue()+" ");
            inOrderTraverse(root.getRight());
        }
    }

    //中序遍历  非递归
    public void nrInOrderTraverse(){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;    //找到根节点
        while (node!=null || !stack.isEmpty()){
            //将左子树 节点全部加入
            while (node!=null){
                stack.push(node);
                node = node.getLeft();
            }
            //弹出第一个
            node = stack.pop();
            System.out.println(node.getValue()+" ");
            node = node.getRight();
        }
    }





}
