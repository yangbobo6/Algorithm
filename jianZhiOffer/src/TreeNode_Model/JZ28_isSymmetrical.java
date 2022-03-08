package TreeNode_Model;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

/**
 * @Author: yangbo
 * @Date: 2022-02-17-20:45
 * @Description:   对称二叉树
 */

public class JZ28_isSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        return pRoot==null&&isSuccess(pRoot.left,pRoot.right);
    }

    public boolean isSuccess(TreeNode l,TreeNode r){
        if(l==null&&r==null){
            return true;
        }else if(l==null||r==null){
            return false;
        }

        if(l.val!=r.val){
            return false;
        }else {
            return isSuccess(l.left,r.right)&&isSuccess(l.right,r.left);
        }

    }
}
