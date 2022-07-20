package top101.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: yangbo
 * @Date: 2022-07-17-16:56
 * @Description:
 */
public class BM41_solve {
    
    
    public int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        TreeNode root = reConstructBinaryTree(xianxu,zhongxu);
        Deque<TreeNode> deque = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size!=0){
                TreeNode node = deque.poll();
                if(size==1){
                    list.add(node.val);
                }
                if(node.left!=null){
                    deque.add(node.left);
                }
                if(node.right!=null){
                    deque.add(node.right);
                }
                size--;
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    
    
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
