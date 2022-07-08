package top101.linklist;

/**
 * @Author: yangbo
 * @Date: 2022-07-08-22:10
 * @Description:
 */
public class BM7_EntryNodeOfLoop {
    
    
    
    //双指针  注意边界条件
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }

        fast = pHead;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
