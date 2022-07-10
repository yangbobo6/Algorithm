package collection;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: yangbo
 * @Date: 2022-07-10-10:33
 * @Description:
 */
public class DequeTest1 {
    
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,-3,2,-5,-6,5,6,-8,-9,-10,9,-11,-13,-14,13,-16,15,-17,17,-19,-20,19,-24,23,-25,24,25,-27,26,27,29,-31,30,-33,32,-35,35,36,-38,37,-40,39,-41,40,-42,-43,-44,45,-48,-49,-51,50,-54,53,54,-56,-57,56,-58,-59,-60,62,63,64,-66,65,67,-69,68,-71,70,71,-73,72,-74,73,-78,77,-79,78,-81,80,82,83,84,-86,-87,86,-88,-89,88,-92,93,95,-97,96,-98,-99,98,99};

 
        Arrays.sort(arr1);

        for (int a:arr1
             ) {
            System.out.println(a);
        }
    }
    
}
