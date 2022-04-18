package array;

/**
 * @Author: yangbo
 * @Date: 2022-04-14-20:02
 * @Description:  删除排好序的重复的元素   双指针法
 */
public class code26_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int low = 0;
        int high ;

        for (high = low+1; high < nums.length; high++) {
            if(nums[high]==nums[low]){
                continue;
            }
            if (nums[high]!=nums[low]){
                low++;
                nums[low] = nums[high];
            }
        }
        return low+1;
    }
}
