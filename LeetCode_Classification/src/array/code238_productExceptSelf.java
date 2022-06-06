package array;

/**
 * @Author: yangbo
 * @Date: 2022-06-05-11:13
 * @Description:
 */
public class code238_productExceptSelf {
    
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = nums[0];
        for (int i = 1; i < len; i++) {
            left[i] = left[i-1]*nums[i];
        }
        
        right[len-1] = nums[len-1];
        for (int i = len-2; i >= 0; i--) {
            right[i] = right[i+1]*nums[i];
        }
        nums[0] = right[1];
        nums[len]= left[len-2];
        for (int i = 1; i < len; i++) {
            nums[i] = left[i-1]*right[i+1];
        }
        return nums;
    }
}
