package collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: yangbo
 * @Date: 2022-07-10-10:33
 * @Description:
 */
public class DequeTest1 {
    
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);

        System.out.println(deque);
        
        deque.pollFirst();
        deque.pollFirst();

        System.out.println(deque);
    }
    
}
