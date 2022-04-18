package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-04-18-8:25
 * @Description:    三数之和
 */
public class code15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;

        int left, right;
        for (int i = 0; i < len; i++) {
            //注意数组越界  ------
            if (nums[i] > 0) {
                return lists;
            }
            //去重复
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            left = i + 1;
            right = len - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    //去重复
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return lists;
    }
}
