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
        Deque<Character> deque = new LinkedList<>();
        deque.add('{');
        deque.add('[');
        deque.add('(');

        System.out.println(deque.getFirst());
    }
    
}
