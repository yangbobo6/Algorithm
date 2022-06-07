package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangbo
 * @Date: 2022-06-06-20:03
 * @Description:  数组中找出  出现最多的两个值  容器
 * 
 * [4, 1,-1,2,-1,2]
 * 2
 */
public class code347_topKFrequent {

    public static void main(String[] args) {
        code347_topKFrequent c = new code347_topKFrequent();
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        int k = 2;
        c.topKFrequent(nums,k);
    }
    
    int val ;
    
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(map.containsKey(nums[i])){
                int value = map.get(nums[i]);
                map.put(nums[i],value++);
            }else {
                map.put(nums[i],1);
            }
        }
        
        int max = Integer.MIN_VALUE;
        
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            for (Map.Entry<Integer,Integer> entry:map.entrySet()
            ) {
                System.out.println(entry.getKey() +" ---- "+entry.getValue());
                if(entry.getValue()>max){
                    max = entry.getValue();
                    System.out.println("当下max:  "+max);
                    this.val = entry.getKey();
                    System.out.println("当下key：  "+val);
                }
            }
            res[i] = this.val; 
            map.remove(this.val);
            max = Integer.MIN_VALUE;
        }
        
        return res;
    }
}
