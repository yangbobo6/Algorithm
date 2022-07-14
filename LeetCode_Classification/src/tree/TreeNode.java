package tree;

/**
 * @Author: yangbo
 * @Date: 2022-03-08-23:00
 * @Description: 中序遍历二叉树
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
