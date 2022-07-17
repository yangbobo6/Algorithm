package top101.binaryTree;

/**
 * @Author: yangbo
 * @Date: 2022-07-14-21:05
 * @Description:  合并二叉树  
 */
public class BM32_mergeTrees {
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        //合并二叉树  思考返回值是 TreeNode类型
        if (t1==null&&t2==null){
            return null;
        }
        if(t2==null){
            return t1;
        }
        if (t1==null){
            t1 = t2;
        }
        
        t1.val += t2.val;
        
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
}
