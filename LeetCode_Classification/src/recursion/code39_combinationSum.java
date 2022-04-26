package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-04-26-20:28
 * @Description:
 */
public class code39_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //进行排序
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates,target,ans,combine,0);
        return ans;
    }
    
    public void dfs(int[] candidates,int target,List<List<Integer>> ans,List<Integer> combine,int idx){
        if(idx == candidates.length){
            return;
        }
        
        if(target==0){
            ans.add(new ArrayList<>(combine));
            return;
        }
        
        //直接跳过
        dfs(candidates,target,ans,combine,idx+1);
        //选择当前数
        if(target-candidates[idx]>=0){
            combine.add(candidates[idx]);
            dfs(candidates,target-candidates[idx],ans,combine,idx);
            combine.remove(combine.size()-1);
        }
    }
}
