package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangbo
 * @Date: 2022-05-31-8:52
 * @Description:
 */
public class code169_majorityElement {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()
             ) {
            if(entry.getValue()>(len/2)){
                return entry.getKey();
            }
        }
        return 0;
    }
}
