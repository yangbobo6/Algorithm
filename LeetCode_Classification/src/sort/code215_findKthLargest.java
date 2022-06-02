package sort;

import java.util.Arrays;

/**
 * @Author: yangbo
 * @Date: 2022-06-01-21:27
 * @Description: 排序
 */
public class code215_findKthLargest {
    //借助api
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        int index = len-k;
        return nums[index];
        
    }
    //快速排序解法
    
    
    //堆排序解法
}
