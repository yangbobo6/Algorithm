package hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: yangbo
 * @Date: 2022-06-08-11:45
 * @Description:
 */
public class code448_findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        Set<Integer> set  =new HashSet<>();
        for (int x:nums
             ) {
            set.add(x);
        }
        for (int i = 1; i <=len ; i++) {
            if(!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}
