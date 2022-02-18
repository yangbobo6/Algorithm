package TreeNode_Model;

/**
 * @Author: yangbo
 * @Date: 2022-02-18-13:41
 * @Description:
 */

 class TreeNode1 {
     int val = 0;
     TreeNode1 left = null;
     TreeNode1 right = null;
 }
public class JZ82_hasPathSum {
    public boolean hasPathSum (TreeNode1 root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null&&root.val==sum){
            return true;
        }
        sum -= root.val;
        return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);
    }

}
