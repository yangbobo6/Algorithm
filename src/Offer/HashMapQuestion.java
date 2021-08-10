package Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangsan
 * @date 2021-06-01 10:32
 */
public class HashMapQuestion {
    public static int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < array.length; i++) {
//            if(!map.containsKey(array[i])){
//                map.put(array[i],1);
//            }else {
//                int count = map.get(array[i]);
//                map.put(array[i],count++);
//            }
            map.put(array[i],map.getOrDefault(array[i],0)+1);
        }
        int max=0,res=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()>max) {
                max=Math.max(max,entry.getValue());
                res=entry.getKey();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a={1,2,3,3,4,5,6,7,1,2,3,3,3,3,3,3,3,3,3,3};
        int i = MoreThanHalfNum_Solution(a);
        System.out.println(i);
    }
}
