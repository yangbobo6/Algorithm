package collection;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author: yangbo
 * @Date: 2022-06-18-23:12
 * @Description:
 */
public class DequeTest {
    public static void main(String[] args) {
        //双端队列
        Deque<String> deque = new LinkedList<>();
        //尾部添加元素  抛出异常
        deque.add("yangbo");
        //尾部添加元素  抛出异常
        deque.addLast("boo");
        deque.addFirst("bo");
        
        //返回true  false
        deque.offer("boo1");
        deque.offerFirst("boo2");
        deque.offerLast("booo3");
        
        //查看元素  无返回 null
        deque.peek();
        deque.peekFirst();
        deque.peekLast();
        //查看元素  无返回异常
        deque.getFirst();
        deque.getLast();
        
        //移除  返回null
        deque.poll();
        deque.pollFirst();
        deque.pollLast();
        
        //移除  返回异常
        deque.remove();
        deque.removeLast();
        deque.removeFirst();
        
        deque.contains("boo");
        deque.size();
        
        //循环遍历
        Iterator<String> iterator = deque.iterator();
        while(iterator.hasNext()){
            String name = iterator.next();
        }

        for (String s:deque
             ) {
            System.out.println(s);
        }
        
    }
}
