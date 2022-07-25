package top101.dp;

/**
 * @Author: yangbo
 * @Date: 2022-07-25-22:29
 * @Description:  🐸跳台阶
 */
public class BM63_jumpFloor {
    
    public int jumpFloor(int target){
        int[] dp = new int[target+1];
        for (int i = 0; i < target+1; i++) {
            dp[i] = -1;
        }
        jumpDp(dp,target);
        return dp[target];
    }
    
    public int jumpDp(int[] dp,int target){
        if(dp[target]!=-1){
            return dp[target];
        }
        if(target==1){
            dp[target] = 1;
            return dp[target];
        }
        if(target==2){
            dp[target] = 2;
            return target;
        }
        dp[target] = jumpDp(dp,target-1)+jumpDp(dp,target-2);
        return dp[target];
    }
    
    
    
    public int jumpFloor1(int target){
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        return jumpFloor1(target-1)+jumpFloor1(target-2);
    }
}
