package top101.binaryTree;

/**
 * @Author: yangbo
 * @Date: 2022-07-14-20:59
 * @Description:
 */
public class BM29_hasPathSum {
    //从跟到叶子节点，各个值之和为 sum
    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        //如果想一个方法下来，可以用 sum--的方式，判断什么时候为0
        if (root==null){
            return false;
        }
        int sumValue = 0;
        return hasPathSum(root,sum,sumValue);
    }
    public boolean hasPathSum(TreeNode root,int sum,int sumValue){
        if (root==null){
            return false;
        }
        //一定注意 在哪里增加值！！！调试了半小时
        sumValue += root.val;
        //主要  root.left == null && root.right == null判断！！！
        if (sumValue==sum && root.left == null && root.right == null){
            return true;
        }
        return hasPathSum(root.left,sum,sumValue)||hasPathSum(root.right,sum,sumValue);
    }
}
