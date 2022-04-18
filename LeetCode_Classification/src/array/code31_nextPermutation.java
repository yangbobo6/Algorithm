package array;

import java.util.Arrays;

/**
 * @Author: yangbo
 * @Date: 2022-04-18-17:15
 * @Description:   下一个排列数
 */
public class code31_nextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        //注意边界值 -----
        for (int i = len-1; i > 0 ; i--) {
            //第一步 找到第一对正序的
            if(nums[i]>nums[i-1]){
                //找到比num[i-1]大的最小的值
                Arrays.sort(nums,i,len);
                for (int j = i; j <len; j++) {
                    if(nums[j]>nums[i-1]){
                        int temp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] = temp;
                        return;
                    }
                }
            }
        }
        //否则是最后一种情况
        Arrays.sort(nums);
        return;
    }
}
