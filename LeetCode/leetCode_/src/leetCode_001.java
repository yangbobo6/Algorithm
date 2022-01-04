public class leetCode_001 {
    public int[] twoSum(int[] nums, int target) {
        //两数之和
        int []out = new int[2];
        //两层循环接收
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                //找不到
                if(nums[i]+nums[j]!=target){
                    continue;
                }
                //找到
                else {
                    out[1]=i;
                    out[2]=j;
                    break;
                }
            }
        }
        return out;
    }
}
