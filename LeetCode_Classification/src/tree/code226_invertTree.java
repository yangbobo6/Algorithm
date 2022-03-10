package tree;

/**
 * @Author: yangbo
 * @Date: 2022-03-10-21:06
 * @Description:     反转二叉树
 */
public class code226_invertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        dfs(root.left,root.right);
        return root;

    }

    public void dfs(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return;
        }
        TreeNode tem = left;
        left = right;
        right = tem;
        dfs(left.left,right.right);
        dfs(left.right,right.left);
    }

}
