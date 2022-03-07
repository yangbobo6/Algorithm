package linklist;

import java.util.HashSet;

/**
 * @Author: yangbo
 * @Date: 2022-03-07-22:01
 * @Description:
 */
public class code141_hasCycle {
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
}
