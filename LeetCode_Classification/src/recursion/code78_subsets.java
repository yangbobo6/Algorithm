package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-05-25-17:10
 * @Description:  递归   回溯
 */
public class code78_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        int deep = 0;
        
        dfs(nums,len,deep,list,lists);
        return lists;
    }
    
    public void dfs(int[] nums,int len,int deep,List<Integer> list,List<List<Integer>> lists){
        if(deep==len){
            List<Integer> list1 = new ArrayList<>(list);
            lists.add(list1);
            return;
        }
        dfs(nums,len,deep+1,list,lists);
        list.add(nums[deep]);
        dfs(nums,len,deep+1,list,lists);
        list.remove(list.size()-1);
    }
}
