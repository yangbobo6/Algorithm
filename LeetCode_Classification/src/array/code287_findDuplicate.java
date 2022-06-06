package array;

import java.util.Arrays;

/**
 * @Author: yangbo
 * @Date: 2022-06-05-15:53
 * @Description:
 */
public class code287_findDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (fast!=slow){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        fast = slow;
        slow = 0;
        while (fast!=slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
