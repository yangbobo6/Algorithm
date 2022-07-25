package top101.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: yangbo
 * @Date: 2022-07-24-22:22
 * @Description: 没有重复的全排列
 */
public class BM56_permuteUnique {
    
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        boolean[] mark = new boolean[num.length];
        Arrays.sort(num);
        ArrayList<Integer> list = new ArrayList<>();
        dfs(num,list,mark);
        return lists;
    }
    
    public void dfs(int[] num,ArrayList<Integer> list,boolean[] mark){
        if(num.length == list.size()){
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            //如果已经被标记过了，说明已经添加过了，跳过
            if(mark[i]){
                continue;
            }
            //如果 mark[i-1]没有用，并且 两数字相等
            if(i>0 && num[i]==num[i-1] && !mark[i-1]){
                continue;
            }
            list.add(num[i]);
            mark[i] = true;
            dfs(num,list,mark);
            list.remove(list.size()-1);
            mark[i] = false;
        }
    }
}
