package dp;

/**
 * @Author: yangbo
 * @Date: 2022-05-31-15:20
 * @Description:   打家劫舍  递推公式
 */
public class code198_rob {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int N = nums.length;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int k = 2; k <= N; k++) {
            //递推公式 ***
            dp[k] = Math.max(dp[k-1],dp[k-2]+nums[N-1]);
        }
        return dp[N];
    }
    
}
