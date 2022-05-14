package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: yangbo
 * @Date: 2022-04-09-22:19
 * @Description: 上台阶问题
 */
public class code70_climbStairs {
    public int climbStairs(int n) {
        int[] record = new int[n];
        int res = climbStairs(n,record);
        
        return res;
    }
    
    public int climbStairs(int n,int[] record){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(record[n]==0){
            record[n] = climbStairs(n-1,record)+climbStairs(n-2,record); 
        }
        return record[n];
    }
}
