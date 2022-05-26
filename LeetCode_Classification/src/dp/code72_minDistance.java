package dp;

/**
 * @Author: yangbo
 * @Date: 2022-05-25-15:34
 * @Description:  单词的替换  horse替换成 ros  至少需要几步
 * 
 * dp[i][j] 表示 word1 的i 到 word2的j  需要几步 
 */
public class code72_minDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0]+1;
        }

        for (int i = 1; i <= n ; i++) {
            dp[0][i] = dp[0][i-1]+1;
        }
        
        
        for(int i = 1;i<=m;i++){
            for (int j = 1; j <= n ; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]= Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        
        return dp[m][n];
        
    }
}
