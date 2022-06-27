package linklist;

import java.util.HashSet;

/**
 * @Author: yangbo
 * @Date: 2022-03-07-22:01
 * @Description:  判断一个链表中是否有环，有的话返回true   利用hashset   add返回boolean方法
 */
public class code141_hasCycle {
    //hashset
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (head!=null){
            boolean add = hashSet.add(head);
            head = head.next;
            if (!add){
                return true;
            }
        }
        return false;
    }
    
    //双指针
    public boolean hasCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    
}
