package array;

/**
 * @Author: yangbo
 * @Date: 2022-06-04-17:25
 * @Description:  移动0至最末尾
 */
public class code283_moveZeroes {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if(len==0){
            return;
        }
        int j = 0;
        for(int i = 0;i<len;i++){
            if(nums[i]!=0){
                nums[j++]=nums[i];
            }
        }
        for (int i = j;i<len;i++){
            nums[i] = 0;
        }
    }
}
