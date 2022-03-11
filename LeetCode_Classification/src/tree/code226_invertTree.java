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
        dfs(root);
        return root;

    }

    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        dfs(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}
