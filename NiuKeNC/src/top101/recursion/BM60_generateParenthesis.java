package top101.recursion;

import java.util.ArrayList;

/**
 * @Author: yangbo
 * @Date: 2022-07-25-20:21
 * @Description:  括号的生成，有效括号
 */
public class BM60_generateParenthesis {

    
    public ArrayList<String> generateParenthesis (int n) {
        // write code here
        ArrayList<String> list = new ArrayList<>();
        dfs(list,0,0,"",n);
        return list;
    }
    //当左括号的数量小于n，增加左
    //当右括号小于左括号，增加右

    public void dfs(ArrayList<String> res,int open,int close,String string,int n){
        if(string.length() == n<<1){
            res.add(string);
            return;
        }
        if(open<n){
            dfs(res,open+1,close,string+"(",n);
        }
        if(open>close){
            dfs(res,open,close+1,string+")",n);
        }
    }
}
