package linklist;

/**
 * @Author: yangbo
 * @Date: 2022-04-18-15:42
 * @Description:
 */
public class code24_swapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode(0);
        if(head==null||head.next==null){
            return head;
        }
        
        h.next = head;
        ListNode p = head;
        ListNode q = head.next;
        head = h;

        while(q!=null){
            swapNode(h,p,q);
            h = p;
            p = p.next;
            if(p!=null){
                q = p.next;
            }else{
                break;
            }
        }
        return head.next;
    }

    public void swapNode(ListNode h,ListNode p,ListNode q){
        h.next = q;
        p.next = q.next;
        q.next = p;
    }
}
