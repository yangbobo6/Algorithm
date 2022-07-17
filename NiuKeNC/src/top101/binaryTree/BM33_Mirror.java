package top101.binaryTree;

/**
 * @Author: yangbo
 * @Date: 2022-07-14-21:47
 * @Description:
 */
public class BM33_Mirror {
    //不能这样用------
//    public TreeNode Mirror (TreeNode pRoot) {
//        //转变为二叉树的镜像
//        revertMirror(pRoot.left,pRoot.right);
//        return pRoot;
//    }
//    
//    public void revertMirror(TreeNode node1,TreeNode node2){
//        if(node1==null&&node2==null){
//            return;
//        }
//        TreeNode temp = node1;
//        node1 = node2;
//        node2 = temp;
//        revertMirror(node1.left,node2.right);
//        revertMirror(node1.right,node2.left);
//    }

    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot==null)
            return null;
        Mirror(pRoot.left);
        TreeNode t;
        t = pRoot.left;
        pRoot.left= pRoot.right;
        pRoot.right = t;
        //注意   不同的遍历，对应不同
        Mirror(pRoot.left);
        return pRoot;
    }

    //二叉树的镜像   
    public TreeNode Mirror1 (TreeNode pRoot) {
        //转变为二叉树的镜像
        if(pRoot==null){
            return null;
        }
        Mirror1(pRoot.left);
        TreeNode node = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = node;
        Mirror(pRoot.left);
        return pRoot;
    }
}
