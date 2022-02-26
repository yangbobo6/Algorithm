package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-02-25-21:57
 * @Description:   dfs 深度优先遍历
 */
public class code22_generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res,"",0,0,n);
        return res;
    }

    //count1统计“(”的个数，count2统计“)”的个数
    public void generate(List<String> res,String ans,int count1,int count2,int n){
        if(count1 > n||count2 > n){
            return;
        }
        if(count1 == n && count2 == n){
            res.add(ans);
        }
        if(count1>=count2){
            String ans1 = new String(ans);
            generate(res,ans+"(",count1+1,count2,n);
            generate(res,ans+")",count1,count2+1,n);
        }

    }


}
