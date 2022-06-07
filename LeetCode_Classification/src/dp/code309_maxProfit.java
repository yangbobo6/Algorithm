package dp;/**
 *@Author: yangbo
 *@Date: 2022-06-06-10:21
 *@Description:   买卖股票的最佳时期  含有冷冻期
 */
public class code309_maxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][3];
        if(len<=1){
            return 0;
        }
        
        //最初状态
        dp[0][0] = 0;   //第一天不持有股票  没有买
        dp[0][1] = -1*prices[0];  //持有股票
        dp[0][2] = 0;  //第一天卖出股票

        for (int i = 1; i < len; i++) {  //和前一天的关系
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]);   //前一天  1.不持有补票没有买 2.持有卖出
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);  //1. 前一天持有股票  2.当天购买股票
            dp[i][2] = dp[i-1][1]+prices[i];        //前一天肯定持有股票  
        }
        
        return Math.max(dp[len-1][0],dp[len-1][2]);
    }
}
