package com.BinaryTree;

public class TreeNode {
    private String value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(){}

    public TreeNode(String value) {
        //super();
        this.value = value;
    }

    public TreeNode(String value, TreeNode left, TreeNode right) {
        //super();
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String getValue() {
        return value;
    }
    public TreeNode getLeft() {
        return left;
    }
    public TreeNode getRight() {
        return right;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public void setRight(TreeNode right) {
        this.right = right;
    }
}
