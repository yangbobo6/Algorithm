package linklist;

/**
 * @Author: yangbo
 * @Date: 2022-04-07-11:21
 * @Description:  删除倒数第n个节点
 */
public class code19_removeNthFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        head.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
       
        code19_removeNthFromEnd code19_removeNthFromEnd = new code19_removeNthFromEnd();
        code19_removeNthFromEnd.removeNthFromEnd(head,2);
        
    }
    
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode p = head;
        //bug  写成if
        while (p!=null){
            p = p.next;
            count++;
        }
        count = count - n;
        p = head;
        if(count<0){
            return null;
        }else if(count==0){
            head = head.next;
            return head;
        } else {
            while (count!=1){
                p = p.next;
                count --;
            }
            //在这出bug
            p.next = p.next.next;
            return head;
        }
    }
}
