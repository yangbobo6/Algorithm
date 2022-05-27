package tree;

/**
 * @Author: yangbo
 * @Date: 2022-05-26-22:09
 * @Description:  是否是二叉搜索树？？  中序遍历
 */
public class code98_isValidBST {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        //访问当前节点
        if(root.val<=pre){
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
}
