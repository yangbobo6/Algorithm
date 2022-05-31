package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: yangbo
 * @Date: 2022-05-30-21:50
 * @Description: 数组中 连续的数字（不一定位置连续）
 */
public class code128_longestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int a : nums){
            set.add(a);
        }
        int res = 0;
        for(int a: nums){
            if(!set.contains(a-1)){
                int y = a;
                while(set.contains(y+1)){
                    y++;
                }
                res = Math.max(res,y-a+1);
            }
        }
        return res;
        
    }   
}
