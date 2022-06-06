package dp;

import java.util.Arrays;

/**
 * @Author: yangbo
 * @Date: 2022-06-05-18:00
 * @Description:  最长递增子序列
 */
public class code300_lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len==0){
            return 0;
        }
        int[] dp = new int[len];
        int res = 0;
        //初始化为1
        Arrays.fill(dp,1);
        for (int i = 0;i<len;i++){
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            //代表一次循环的开始
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
