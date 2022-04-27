package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-04-27-11:22
 * @Description:  全排列  递归***
 */
public class code46_permute {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return res; 
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        //数组，长度，深度，存储一个解，是否被占用，res
        dfs(nums,len,0,path,used,res);
        return res;
    }
    public void dfs(int[] nums,int len,int depth,
                    List<Integer> path,boolean[] used,
                    List<List<Integer>> res){
        //边界
        if(depth == len){
            //注意不要
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i<len;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,len,depth+1,path,used,res);
                //回溯
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
