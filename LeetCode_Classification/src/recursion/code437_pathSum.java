package recursion;
import linklist.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangbo
 * @Date: 2022-06-12-21:37
 * @Description:  前缀树 
 */
public class code437_pathSum {
    public int pathSum(TreeNode root, int targetSum) {
        //key是前缀和，value是大小为key的前缀和出现的次数
        Map<Integer,Integer> prefixSumCount = new HashMap<>();
        //前缀和为0的一条路径
        prefixSumCount.put(0,1);
        //前缀和的递归思路
        return recursionPathSum(root,prefixSumCount,targetSum,0);
        
    }
    private int recursionPathSum(TreeNode node,Map<Integer,Integer> prefixSumCount,int target,int currSum){
        // 递归终止条件
        if(node==null){
            return 0;
        }
        //本层要做的事
        int res = 0;
        //当前路径和
        currSum += node.val;
        
        res += prefixSumCount.getOrDefault(currSum-target,0);
        prefixSumCount.put(currSum,prefixSumCount.getOrDefault(currSum,0)+1);
        
        res += recursionPathSum(node.left,prefixSumCount,target,currSum);
        res += recursionPathSum(node.right,prefixSumCount,target,currSum);
        
        prefixSumCount.put(currSum,prefixSumCount.get(currSum)-1);
        return res;
    }
}
