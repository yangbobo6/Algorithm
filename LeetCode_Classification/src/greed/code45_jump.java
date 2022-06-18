package greed;

/**
 * @Author: yangbo
 * @Date: 2022-06-14-23:25
 * @Description:
 */
public class code45_jump {
    public int jump(int[] nums){
        int position = nums.length-1;
        int steps = 0;
        while(position>0){
            for (int i = 0; i < position; i++) {
                if(i+nums[i]>=position){
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
