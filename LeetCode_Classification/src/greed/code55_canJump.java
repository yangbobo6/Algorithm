package greed;

/**
 * @Author: yangbo
 * @Date: 2022-05-14-21:15
 * @Description:  如果数组里面没有0，则一定可以走通
 * 
 * 思路 ： 贪心   每次寻找该跳跃的最大距离
 */
public class code55_canJump {

    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int cover = nums[0];
        for (int i = 1;i<=cover;i++){
            cover = Math.max(cover,i+nums[i]);
            if(cover>=nums.length-1){
                return true;
            }
        }
        return false;
    }
    
//    public boolean canJump(int[] nums) {
//        int deep = 0;
//        int len = nums.length-1;
//        boolean b = dfs(nums,deep,len);
//        
//        return b;
//    }
//    
//    public boolean dfs(int[] nums,int deep,int len){
//        
//        if(deep>=len){
//            return true;
//        }
//        
//        int ele = nums[deep];
//        boolean flag;
//        for (int i = 1;i<=ele;i++){
//            boolean b = dfs(nums,deep+i,len);
//            deep = deep-i;
//            flag = b;
//        }
//        return false;
//    }
}
