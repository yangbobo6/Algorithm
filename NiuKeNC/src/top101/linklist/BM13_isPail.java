package top101.linklist;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: yangbo
 * @Date: 2022-07-09-19:25
 * @Description: 判断是否为 回文链表
 */
public class BM13_isPail {
    public boolean isPail (ListNode head) {
        // write code here
        
        //先寻找链表的中点
        ListNode fast = head;
        ListNode slow = head;
        //注意判断条件~~~~
        while(fast!=null&&fast.next!=null){ 
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow;
        slow = head;
        
        //将链表后半部分放入到栈中
        Deque<ListNode> deque = new LinkedList<>();
        while (fast!=null){
            deque.add(fast);
            fast = fast.next;
        }
        //输出栈内元素，并且和链表的前一部分比较
        while (deque.isEmpty()){
            if (slow.val!=deque.pop().val){
                slow = slow.next;
                return false;
            }
        }
        return true;
        
    }
}
