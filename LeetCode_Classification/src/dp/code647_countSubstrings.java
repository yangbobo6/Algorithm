package dp;

/**
 * @Author: yangbo
 * @Date: 2022-06-11-16:36
 * @Description: 所有的回文子串  和第五题一样
 */
public class code647_countSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int ans = 0;
        //一定注意 i,j循环条件   i倒着循环，保证dp[i+1][j-1]是已经计算过的
        for (int i = len-1; i <=0 ; i++) {
            for (int j = 0; j < len; j++) {
                if(s.charAt(i)==s.charAt(j)&&(j-i<2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
