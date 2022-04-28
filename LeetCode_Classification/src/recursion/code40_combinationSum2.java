package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-04-28-21:58
 * @Description:
 */
public class code40_combinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        
        int start = 0;
        int sum = 0;
        dfs(ans,candidates,target,combine,start,sum);
        return ans;
    }
    
    public void dfs(List<List<Integer>> ans,int[] candidate,int target,List<Integer> combine,int start,int sum){
        if(start<candidate.length &&sum == target){
            ans.add(new ArrayList<>(combine));
            return;
        }
        if (start==candidate.length){
            return;
        }
        if(start>0&&candidate[start]==candidate[start-1]){
            ;
        }
        
        dfs(ans,candidate,target,combine,start+1,sum);
        
        if (sum<target){
            combine.add(candidate[start]);
            
            dfs(ans,candidate,target,combine,start+1,sum+candidate[start]);
            //回溯
            combine.remove(combine.size()-1);
        }
    }
    
}
