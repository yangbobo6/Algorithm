package top101.hash;

import java.util.Arrays;

/**
 * @Author: yangbo
 * @Date: 2022-07-20-21:43
 * @Description:
 */
public class BM53_minNumberDisappeared {
    
    //[0,1,2]
    public int minNumberDisappeared (int[] nums) {
        // write code here
        int len = nums.length;
        Arrays.sort(nums);
        if(nums[len-1]<=0){
            return 1;
        }
        
        int index = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i]>=0){
                index = i;
                break;
            }
        }
        
        int remain = len-index;
        for (int i = index; i < len-1; i++) {
            if(nums[i]+1<nums[i+1]){
                return nums[i]+1;
            }
        }
        return remain+1;
    }
}
