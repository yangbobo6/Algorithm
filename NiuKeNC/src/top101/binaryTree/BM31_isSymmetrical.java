package top101.binaryTree;

/**
 * @Author: yangbo
 * @Date: 2022-07-14-21:00
 * @Description:
 */
public class BM31_isSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null){
            return true;
        }
        //思路  root下面的左右节点遍历
        return isSame(pRoot.left,pRoot.right);
    }

    public boolean isSame(TreeNode node1,TreeNode node2){
        //判断节点   如果1为空  2为空  分别不为空情况
        if(node1==null){
            return node2==null;
        }
        if (node2==null){
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }

        return isSame(node1.left,node2.right)&&isSame(node1.right,node2.left);
    }
}
