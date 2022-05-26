package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangbo
 * @Date: 2022-05-25-16:05
 * @Description:  颜色分类  用map解答    最好用快排   
 */
public class code75_sortColors {
    public void sortColors(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,0);
        map.put(2,0);
        int len = nums.length;
        for (int i = 0;i<len;i++){
            if(nums[i]==0){
                map.put(0,map.get(0)+1);
            }
            if(nums[i]==1){
                map.put(1,map.get(1)+1);
            }
            if(nums[i]==2){
                map.put(2,map.get(2)+1);
            }
        }

        System.out.println(map.get(0)+"  "+ map.get(1)+"  "+map.get(2));
        
        for (int i = 0; i < map.get(0); i++) {
            nums[i] = 0;
        }
        for (int i = map.get(0); i < map.get(1)+map.get(0); i++) {
            nums[i] = 1;
        }
        for (int i = map.get(0)+map.get(1); i < len; i++) {
            nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        code75_sortColors c =  new code75_sortColors();
        c.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
