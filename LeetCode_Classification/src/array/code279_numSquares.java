package array;

/**
 * @Author: yangbo
 * @Date: 2022-06-04-22:00
 * @Description:  完全平方数之和  
 */
public class code279_numSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        if(n==0){
            return 0;
        }
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i-j*j >=0; j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
