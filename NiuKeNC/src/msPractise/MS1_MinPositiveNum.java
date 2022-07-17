package msPractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yangbo
 * @Date: 2022-07-15-21:10
 * @Description:  寻找最小的整数值
 */
public class MS1_MinPositiveNum {
    public int minPositive(int[] nums){
        Arrays.sort(nums);
        int len = nums.length;
        if(nums[len-1]<=0){
            return 1;
        }
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            hashSet.add(nums[i]);
        }

        for (int i = 1; i <= len; i++) {
            if(!hashSet.contains(i)){
                return i;
            }
        }
        return len+1;
    }

    public int minPositive1(int[] nums){
        Arrays.sort(nums);
        int len = nums.length;
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

        for (int i = 1; i <= len-index+1; i++) {
            if(nums[i+index]!=i){
                return i;
            }
        }
        return len-index+2;
        
    }
}
