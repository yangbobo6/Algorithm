package recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: yangbo
 * @Date: 2022-03-13-9:08
 * @Description:  全排列  a b c
 */
public class printAllPermutations {

    public static void main(String[] args) {
        ArrayList<String> abc = Permutation("abc");
        for (String a: abc
             ) {
            System.out.println(a);
        }
    }


    public static ArrayList<String> Permutation(String str){
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length()==0){
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs,0,res);
        //res.sort(null);
        return res;
    }


    //str[i..]范围上所有的字符，都可以在i位置上，后续都去尝试
    //str[0..i-1]范围上是之前做的选择
    //把所有字符串形成的全排列，加入到res里面去
    public static void process(char[] str, int i, ArrayList<String> res){
        //最后一步  加入
        if(i==str.length){
            res.add(String.valueOf(str));
        }

        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if(!visit[str[j]-'a']){        //剪枝操作  去掉重复的
                visit[str[j]-'a'] = true;
                                           //递归代码
                swap(str,i,j);
                process(str,i+1,res);
                swap(str,i,j);             //回溯部分  ，还原成原来的样子
            }

        }
    }

    public static void swap(char[] chs,int i,int j){
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
