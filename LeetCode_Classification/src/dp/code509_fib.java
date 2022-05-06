package dp;

/**
 * @Author: yangbo
 * @Date: 2022-05-06-21:23
 * @Description:  暴力递归 改 动态规划
 */
public class code509_fib {

//    public int fib(int n) {
//        if(n==0){
//            return 0;
//        }
//        if(n==1){
//            return 1;
//        }
//        return fib(n-1)+fib(n-2);
//    }
    
    public int fib(int n){
        int[] dp = new int[n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return fib(n,dp);
    }
    
    public int fib(int n,int[] dp) {
        if(dp[n]!=-1){
            return dp[n];
        }
        
        if(n==0){
            dp[0] = 0;
            return dp[0];
        }
        if(n==1){
            dp[1] = 1;
            return dp[1];
        }
        
        dp[n] =  fib(n-1)+fib(n-2);
        return dp[n];
    }
}
