package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-03-04-21:25
 * @Description:    重点*****  不太懂
 *   dfs  leetcode  画图   寻找l  le  lee  leet  依此寻找
 *
 */
public class code139_wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        //
        boolean[] visited = new boolean[s.length()+1];
        return dfs(s,0,wordDict,visited);
    }
    
    private boolean dfs(String s,int start,List<String> wordDict,boolean[] visited){
        //java指针  指向字符的末尾的下一位，则成功
        for(String word:wordDict){
            int nextStart = start+word.length();
            //直接下一次循环
            if(nextStart>s.length()||visited[nextStart]){
                continue;
            }
            //前面的已经匹配上了
            if(s.indexOf(word,start)==start){
                if(nextStart==s.length()||dfs(s,nextStart,wordDict,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
