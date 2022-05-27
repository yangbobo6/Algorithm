package tree;

/**
 * @Author: yangbo
 * @Date: 2022-05-26-21:54
 * @Description:  n个节点  求二叉搜索树有多少种
 */
public class code96_numTrees {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < i+1; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
