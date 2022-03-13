package recursion;

import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-03-13-8:05
 * @Description:  ---打印一个字符的所有子序列---
 */
public class printAllSubsequences {
    public static void process(char[] str, int i, List<Character> res){
        if(i==str.length){
            printList(res);
            return;
        }
        List<Character> resKeep = copyList(res);
        resKeep.add(str[i]);
        process(str, i+1, resKeep);   //要当前字符串

        List<Character> resNoInclude = copyList(res);
        process(str,i+1,resNoInclude);  //不要当前字符串
    }

    //省空间写法  回溯写法
    public static void process(char[] str,int i){
        if(i== str.length){
            System.out.println(String.valueOf(str));
            return;
        }
        process(str, i+1);  //要当前字符
        char tem = str[i];
        str[i] = 0;
        process(str,i+1);  //不要当前字符
        str[i] = tem;
    }

    public static void printList(List<Character> res){
        //...
    }

    public static List<Character> copyList(List<Character> res){
        return null;
    }
}
