package linklist;

/**
 * @Author: yangbo
 * @Date: 2022-03-06-20:18
 * @Description:  反转链表   头插法 ***
 */
public class code206_reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode h = new ListNode();
        h.next = null;    //设置头节点  直接指向null
        ListNode p = null;
        while (head!=null){
            p = head;
            head = head.next;
            p.next = h.next;
            h.next = p;
        }
        return h.next;
    }
}
