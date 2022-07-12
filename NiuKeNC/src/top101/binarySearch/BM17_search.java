package top101.binarySearch;

/**
 * @Author: yangbo
 * @Date: 2022-07-11-7:30
 * @Description: 二分查找
 */
public class BM17_search {
    public int search (int[] nums, int target) {
        // write code here
        int size = nums.length;
        int left = 0;
        int right = size-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right = mid-1; 
            }else {
                left = mid+1;
            }
        }
        return -1;
    }
}
