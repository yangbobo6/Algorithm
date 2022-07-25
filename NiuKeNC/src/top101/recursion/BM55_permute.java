package top101.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: yangbo
 * @Date: 2022-07-24-21:43
 * @Description:   全排列
 */
public class BM55_permute {
    
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<Integer> list = new ArrayList<>();
        if(num.length==0){
            return lists;
        }
        Arrays.sort(num);
        dfs(num,list);
        return lists;
    }
    
    public void dfs(int[] num,ArrayList<Integer> list){
        if(list.size()==num.length){
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if(!list.contains(num[i])){
                list.add(num[i]);dfs(num,list);
                list.remove(list.size()-1);
            }
        }
    }
}
