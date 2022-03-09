package tree;

/**
 * @Author: yangbo
 * @Date: 2022-03-08-23:35
 * @Description:   求二叉树最大深度
 */
public class code104_maxDepth {
    public int maxDepth(TreeNode root) {
        int depth = inorderDepth(root);
        return depth;
    }

    public int inorderDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = inorderDepth(root.left);
        int right = inorderDepth(root.right);
        return Math.max(left,right)+1;
    }

}
