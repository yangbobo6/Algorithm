package top101.dp;

/**
 * @Author: yangbo
 * @Date: 2022-07-25-22:00
 * @Description:
 */
public class BM62_Fibonacci {
    
    public int Fibonacci(int n){
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return fib(dp,n);
    }
    
    public int fib(int[] dp,int n){
        if(dp[n]!=-1){
            return dp[n];
        }
        
        if(n==1){
            dp[1] = 1;
            return dp[1];
        }
        if(n==2){
            dp[2] = 1;
            return dp[2];
        }
        dp[n] = fib(dp,n-1)+fib(dp,n-2);
        return dp[n];
        
    }
    
    
    //递归
    public int Fibonacci1(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        return Fibonacci1(n-1)+Fibonacci1(n-2);
    }
}
