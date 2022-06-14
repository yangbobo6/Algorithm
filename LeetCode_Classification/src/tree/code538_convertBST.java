package tree;
/**
 * @Author: yangbo
 * @Date: 2022-06-11-23:59
 * @Description:  二叉排序树   转化为累加树
 * 
 * 中序遍历 正好是由大到小此顺序
 * 所以我们只需要反序中序遍历，将累加值填到每个节点
 */
public class code538_convertBST {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root!=null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
    
}
