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
        //左树的深度
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        //更新直径的最大值
        max = Math.max(leftDepth+rightDepth,max);
        //返回左右树最深的
        return Math.max(leftDepth,rightDepth)+1;
    }
}
