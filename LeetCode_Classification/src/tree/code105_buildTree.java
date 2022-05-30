package tree;

/**
 * @Author: yangbo
 * @Date: 2022-05-26-22:45
 * @Description: 先序遍历和中序遍历
 * 
 * 根据先序遍历的第一个确定  树的中间位置
 */
public class code105_buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder,int p_start,int p_end,int[] inorder,int i_start,int i_end){
        if(p_start == p_end){
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);

        //中序遍历中找到根节点的位置
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if(inorder[i]==root_val){
                i_root_index = i;
                break;
            }
        }
        int leftNum = i_root_index-i_start;
        //构造左子树  p起始
        buildTreeHelper(preorder,p_start+1,p_start+leftNum+1,inorder,i_start,i_root_index);

        //构造右子树
        buildTreeHelper(preorder,p_start+leftNum+1,p_end,inorder,i_root_index+1,i_end);
        return root;
    }
    
}
