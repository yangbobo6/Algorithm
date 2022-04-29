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
        dfs(ans,combine,target,start,candidates);
        System.out.println(ans);
        return ans;
        
    }
    
    public void dfs(List<List<Integer>> ans,List<Integer> combine,int target,int start,int[] candidates){
        if(target == 0){
            ans.add(new ArrayList<>(combine));
            return;
        }
        
        
        for(int i = start;i<candidates.length;i++){
            if(target-candidates[i]<0){
                break;
            }
            if(i>1 && candidates[i] == candidates[i-1]){
                continue;
            }
            
            combine.add(candidates[i]);
            dfs(ans,combine,target-candidates[i],i+1,candidates);
            //回溯
            combine.remove(combine.size()-1);
        }
    }

    public static void main(String[] args) {
        code40_combinationSum2 c = new code40_combinationSum2();
        int[] ans = new int[]{1,2,2,2,5};
        int target = 5;
        c.combinationSum2(ans,target);
    }
    
    
    
    
    
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> combine = new ArrayList<>();
//        
//        int start = 0;
//        int sum = 0;
//        dfs(ans,candidates,target,combine,start,sum);
//        return ans;
//    }
//    
//    public void dfs(List<List<Integer>> ans,int[] candidate,int target,List<Integer> combine,int start,int sum){
//        if(start<=candidate.length &&sum == target){
//            List<Integer> list = new ArrayList<>(combine);
//            if(ans.contains(list)){
//                return;
//            }
//            ans.add(list);
//            return;
//        }
//        if(start<=candidate.length && sum == target){
//            ans.add(new ArrayList<>(combine));
//            return;
//        }
//        if (start==candidate.length){
//            return;
//        }
//        if(start>0 && candidate[start] == candidate[start-1]){
//            return;
//        }
//        
//        dfs(ans,candidate,target,combine,start+1,sum);
//        if (sum<target){
//            
//            
//            combine.add(candidate[start]);
//            dfs(ans,candidate,target,combine,start+1,sum+candidate[start]);
//            //回溯
//            combine.remove(combine.size()-1);
//        }
//    }
    
}
