package array;

/**
 * @Author: yangbo
 * @Date: 2022-04-19-16:27
 * @Description:
 */
public class code34_searchRange {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int first = -1;
        int second = -1;
        int[] arr = new int[2];
        
        
        
        for(int i=0;i<len;i++){
            if(target==nums[i]&&first==-1&&second==-1){
                first = i;
            }else if(target == nums[i]&&first!=-1){
                second = i;
            }else{
                continue;
            }
        }
        
        
        
        if(first!=-1&&second==-1){
            arr[0] = first;
            arr[1] = first;
        }else{
            arr[0] = first;
            arr[1] = second;
        }
        return arr;
    }
}
