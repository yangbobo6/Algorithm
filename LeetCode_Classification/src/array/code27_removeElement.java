package array;

/**
 * @Author: yangbo
 * @Date: 2022-04-14-20:18
 * @Description:
 */
public class code27_removeElement {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right]!=val){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
