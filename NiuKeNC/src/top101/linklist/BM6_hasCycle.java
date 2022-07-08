package top101.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yangbo
 * @Date: 2022-07-08-22:09
 * @Description:
 */
public class BM6_hasCycle {
    //hashset方法
    public boolean hasCycle(ListNode head) {
        Set<ListNode> hashset = new HashSet<>();
        while(head!=null){
            if(hashset.contains(head)){
                return true;
            }
            hashset.add(head);
            head = head.next;
        }
        return false;
    }
    //双指针
    public boolean hasCycle1(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    
}
