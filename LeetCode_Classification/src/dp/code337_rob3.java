package dp;

import tree.TreeNode;
import tree.code105_buildTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangbo
 * @Date: 2022-06-06-10:57
 * @Description:
 */
public class code337_rob3 {
    //暴力递归（比较  爷爷和孙子的和  儿子的和   的大小）
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        int money = root.val;
        if(root.left!=null){
            money += (rob(root.left.left)+rob(root.left.right)); 
        }
        if (root.right!=null){
            money+=(rob(root.right.left)+rob(root.right.right));
        }
        return Math.max(money,rob(root.left)+rob(root.right));
    }
    //记忆化搜索
    public static int rob2(TreeNode root){
        Map<TreeNode,Integer> map = new HashMap<>();
        return robInternal(root,map);
    }
    
    private static int robInternal(TreeNode root,Map<TreeNode,Integer> map){
        if(root==null){
            return 0;
        }
        if(map.containsKey(root)){return map.get(root);}
        int money = root.val;
        if(root.left!=null){
            money += (robInternal(root.left.left,map)+robInternal(root.left.right,map));
        }
        if(root.right!=null){
            money += (robInternal(root.right.left,map)+robInternal(root.right.right,map));
        }
        int result = Math.max(money,robInternal(root.left,map)+robInternal(root.right,map));
        map.put(root,result);
        return result;
    }

    
    
    //动态规划
    private static int rob3(TreeNode root){
        int[] result = robDP(root);
        return Math.max(result[0],result[1]);
    }
    private static int[] robDP(TreeNode root){
        if(root==null){
            return new int[2];
        }
        int result[] = new int[2];
        int[] left = robDP(root.left);
        int[] right = robDP(root.right);
        
        //0代表不偷  1代表偷
        //当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
        result[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        //当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
        result[1] = left[0]+right[0]+root.val;
        return result;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{3,4,1,3,5,1};
        int[] inOrder = new int[]{1,4,3,3,5,1};

        code105_buildTree code105_buildTree = new code105_buildTree();
        tree.TreeNode treeNode = code105_buildTree.buildTree(preOrder, inOrder);
        int res = rob2(treeNode);
        System.out.println(res);
    }
    
}
