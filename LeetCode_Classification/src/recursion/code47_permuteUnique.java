package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @Author: yangbo
 * @Date: 2022-04-27-12:40
 * @Description:  全排列（有重复的）  【1，1，2】 --> [112][121][211]
 */
public class code47_permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        boolean[] used = new boolean[len];
        List<Integer> ans = new ArrayList<>();
        dfs(nums,0,len,res,used,ans);
        return res;
    }
    public void dfs(int[] nums,int depth,int len,List<List<Integer>> res,boolean[] used,List<Integer> ans){
        if(depth == len){
//            List<Integer> path = new ArrayList<>(ans);
//            if (!res.contains(path)){
//                res.add(path);
//            }else {
//                return;
//            }
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i = 0;i<len;i++){
            if(!used[i]){
                if(i>0 && nums[i]==nums[i-1] && !used[i-1]){
                    continue;
                }
                ans.add(nums[i]);
                used[i] = true;
                dfs(nums,depth+1,len,res,used,ans);
                used[i] = false;
                ans.remove(ans.size()-1);
            }
        }
    }
}
