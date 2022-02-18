package TreeNode_Model;

public class JZ54_KthNode {
    public int KthNode (TreeNode proot, int k) {
        // write code here
        //先用先序遍历  遍历一遍
        int n = 1;
        if(proot==null||k==0){
            return -1;
        }

        KthNode(proot.left,k);
        n++;
        if(n==k){
            return proot.val;
        }
        KthNode(proot.right,k);
        return -1;
    }

}
