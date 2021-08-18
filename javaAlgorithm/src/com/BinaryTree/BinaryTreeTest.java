package com.BinaryTree;

import java.io.FileNotFoundException;

public class BinaryTreeTest {
    public static void main(String[] args)  {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.buildTree();

        System.out.println("递归中序遍历");
        binaryTree.inOrderTraverse();
        System.out.println("非递归中序遍历");
        binaryTree.nrInOrderTraverse();
    }
}
