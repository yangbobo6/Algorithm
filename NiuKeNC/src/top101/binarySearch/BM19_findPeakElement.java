package top101.binarySearch;

/**
 * @Author: yangbo
 * @Date: 2022-07-12-21:11
 * @Description:  寻找峰值，只返回一个即可
 * 
 * 思路： 下降的不一定有峰值，但是上升的一定有峰值，所以只在上升的找一定可以找到
 */
public class BM19_findPeakElement {
    
    public int findPeakElement (int[] nums) {
        // write code here
        int len = nums.length;
        int left = 0;
        int right = len-1;

        while (left<right){
            int mid = (left+right)/2;
            if(nums[mid]>nums[mid+1]){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return right;
    }
}
