package greed;

/**
 * @Author: yangbo
 * @Date: 2022-05-07-9:30
 * @Description:
 */
public class code53_maxSubArray {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0;i<len;i++){
            sum = sum+nums[i];
            result = Math.max(sum,result);
            if(sum<0){
                sum = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr= new int[]{-2,1};
        code53_maxSubArray c= new code53_maxSubArray();
        c.maxSubArray(arr);
    }
}
