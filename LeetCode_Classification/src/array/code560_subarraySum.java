package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangbo
 * @Date: 2022-06-12-12:07
 * @Description:
 */
public class code560_subarraySum {
    
    //暴力做法
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                int sum = 0;
                for(int i = left;i<=right;i++){
                    sum+=nums[i];
                }
                if(sum==k){
                    count++;
                }
                
            }
            
        }
        return count;
    }
    
    //构造前缀和
    public  int subarraySum1(int[] nums,int k){
        int len = nums.length;
        int[] preSum = new int[len+1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i+1] =preSum[i] + nums[i];
        }
        int count = 0;
        for (int left = 0;left<len;left++){
            for (int right = left; right < len; right++) {
                if(preSum[right+1]-preSum[left]==k){
                    count++;
                }
            }
        }
        return count;
    }

    //构造前缀和  优化
    public int subarraySum2(int[] nums,int k){
        //map存储
        Map<Integer,Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0,1);
        int preSum = 0;
        int count = 0;
        for (int num : nums
             ) {
            preSum += num;
            if(preSumFreq.containsKey(preSum-k)){
                count += preSumFreq.get(preSum-k);
            }
            
            preSumFreq.put(preSum,preSumFreq.getOrDefault(preSum,0)+1);
        }
        
        return count;
    }
}
