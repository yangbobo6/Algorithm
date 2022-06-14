package dp;

import java.util.Arrays;

/**
 * @Author: yangbo
 * @Date: 2022-06-14-23:16
 * @Description:
 */
public class code45_jump {
    public int jump(int[] nums) {
        // 用个dp数组记录到达当前位置的最小步数， 一步步向后遍历
        int n = nums.length;
        int dp[] = new int[n]; // 动态规划数组
        Arrays.fill(dp, Integer.MAX_VALUE);
        int reach[] = new int[n]; // 每个位置最远可以到达的地方
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            reach[i] = i + num;
            for(int j = 0; j < i; j++) {
                if (reach[j] >= i) { //可以到达当前位置
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }

        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        code45_jump c = new code45_jump();
        int[] n = new int[]{2,3,1,1,4};
        c.jump(n);
    }
}
