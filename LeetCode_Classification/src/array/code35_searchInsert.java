package array;

/**
 * @Author: yangbo
 * @Date: 2022-04-19-16:48
 * @Description:
 */
public class code35_searchInsert {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l=0,r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]<target)
                l=mid+1;
            else r=mid-1;
        }
        return l;
    }
}
