package array;

/**
 * @Author: yangbo
 * @Date: 2022-05-30-21:39
 * @Description:  找出数组中的非双数元素
 */
public class code136_singleNumber {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        if(nums.length>0){
            for (int i = 0; i < nums.length; i++) {
                res = res^nums[i];
            }
        }
        return res;
    }
}
