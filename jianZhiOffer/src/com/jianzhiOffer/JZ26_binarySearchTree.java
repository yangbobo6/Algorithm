package com.jianzhiOffer;

public class JZ26_binarySearchTree {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree.left==null&&pRootOfTree.right==null){
            return pRootOfTree;
        }
        TreeNode rTreeNode = ReserveTreeNode(pRootOfTree);
        return pRootOfTree;

    }

    public TreeNode ReserveTreeNode(TreeNode treeNode){
        if(treeNode==null){
            return null;
        }
        ReserveTreeNode(treeNode.left);
        ReserveTreeNode(treeNode.right);
        return treeNode;
    }
}
