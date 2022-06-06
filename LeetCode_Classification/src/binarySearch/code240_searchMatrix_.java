package binarySearch;

/**
 * @Author: yangbo
 * @Date: 2022-06-05-16:56
 * @Description:
 */
public class code240_searchMatrix_ {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            //首行第一个比target大，不用比较，肯定在上一行
            if(matrix[i][0]>target){
                break;
            }
            if(matrix[i][matrix[i].length-1]<target){
                continue;
            }
            int col = binarySearch(matrix[i],target);
            if(col!=-1){
                return true;
            }
            
        }
        return false;
        
    }
    
    private int binarySearch(int[] nums,int target){
        int l = 0;
        int r = nums.length-1;
        while (l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                r = mid -1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
