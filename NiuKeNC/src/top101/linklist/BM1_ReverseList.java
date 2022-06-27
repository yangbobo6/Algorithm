package top101.linklist;

import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-06-27-22:06
 * @Description:
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class BM1_ReverseList {
    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode h = new ListNode(0);
        h.next = null;
        ListNode p = head;
        while (head!=null){
            p = p.next;
            head.next = h.next;
            h.next = head;
            head = p;
        }
        return h.next;
    }

    public ListNode ReverseList1(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode p = head.next;
        ListNode h = head.next;
        head.next = null;
        while (p != null){
            h = h.next;
            p.next = head;
            head = p;
            p = h;
        }
        return head;
    }
}
