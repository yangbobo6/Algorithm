package dp;

import tree.TreeNode;
import tree.code105_buildTree;

/**
 * @Author: yangbo
 * @Date: 2022-07-12-22:28
 * @Description:
 */
public class tanjingRob {

    //动态规划
    public static int rob3(TreeNode root){
        int[] result = robDP(root);
        return Math.max(result[0],result[1]);
    }
    
    public static int[] robDP(TreeNode root){
        if(root==null){
            return new int[2];
        }
        int result[] = new int[2];
        int[] left  = robDP(root.left);
        int[] right = robDP(root.right);

        //0代表不偷  1代表偷
        //当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
        result[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        //当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
        result[1] = left[0]+right[0]+root.val;
        return result;
    }
    
    

    public static void main(String[] args) {
        int[] preOrder = new int[]{3,2,3,3,1};
        int[] inOrder = new int[]{2,3,3,3,1};

        code105_buildTree code105_buildTree = new code105_buildTree();
        tree.TreeNode treeNode = code105_buildTree.buildTree(preOrder, inOrder);
        int result = rob3(treeNode);
        System.out.println(result);
    }
}
