package top101.binaryTree;

import java.util.Arrays;

/**
 * @Author: yangbo
 * @Date: 2022-07-17-16:05
 * @Description:  建立二叉树
 * 
 * 根据 先序遍历 确定要分割的位置，记录此位置，递归遍历
 */
public class BM40_reConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        if(pre==null||pre.length==0){
            return null;
        }
        int rootValue = pre[0];
        if(pre.length==1){
            return new TreeNode(rootValue);
        }
        int rootIndex = 0;
        
        for (int i=0;i<vin.length;i++){
            if(rootValue==vin[i]){
                rootIndex = i;
                break;
            }
        }
        
        TreeNode root = new TreeNode(rootValue);
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,rootIndex+1),Arrays.copyOfRange(vin,0,rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,rootIndex+1,pre.length),Arrays.copyOfRange(vin,rootIndex+1,vin.length));
        
        return root;
    }
}
