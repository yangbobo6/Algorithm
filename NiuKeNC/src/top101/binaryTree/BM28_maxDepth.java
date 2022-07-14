package top101.binaryTree;

/**
 * @Author: yangbo
 * @Date: 2022-07-14-20:58
 * @Description: 二叉树的最大深度
 */
public class BM28_maxDepth {
    public int maxDepth (TreeNode root) {
        // write code here
        int maxDep = 0;
        //新建一个方法，因为要增加参数记录最大层数，如果定义为全局变量，会遍历每个分支
        return maxDep(root,maxDep);
    }
    public int maxDep(TreeNode root,int maxDep){
        if(root == null){
            return maxDep;
        }
        maxDep++;
        int dep = Math.max(maxDep(root.left,maxDep),maxDep(root.right,maxDep));
        return dep;
    }
}
