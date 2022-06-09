package tree;

/**
 * @Author: yangbo
 * @Date: 2022-06-08-12:12
 * @Description:  二叉树的最大直径
 */
public class code543_diameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }
    
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftDepth = diameterOfBinaryTree(root.left);
        int rightDepth = diameterOfBinaryTree(root.right);
        max = Math.max(leftDepth+rightDepth,max);
        return Math.max(leftDepth,rightDepth)+1;
    }
}
