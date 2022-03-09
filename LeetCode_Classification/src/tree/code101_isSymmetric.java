package tree;

/**
 * @Author: yangbo
 * @Date: 2022-03-08-23:23
 * @Description:  对称二叉树
 */
public class code101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean b = isInorderSymmetric(root.left,root.right);
        return b;
    }

    public boolean isInorderSymmetric(TreeNode left,TreeNode right){
        //递归的终点  两个节点都为空
        if(left==null&&right==null){
            return true;
        }
        //两个节点有一个为空   则不对称
        if(left==null || right ==null ){
            return false;
        }
        //两个节点都存在  但是值不一样  不对称
        if(left.val!=right.val){
            return false;
        }
        return isInorderSymmetric(left.left,right.right)&&isInorderSymmetric(left.right,right.left);
    }
}
