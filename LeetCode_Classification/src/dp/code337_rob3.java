package dp;

import linklist.TreeNode;

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
    public int rob2(TreeNode root){
        Map<TreeNode,Integer> map = new HashMap<>();
        return robInternal(root,map);
    }
    
    private int robInternal(TreeNode root,Map<TreeNode,Integer> map){
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
    
}
