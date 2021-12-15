package LinkList_Model;

public class JZ18_DeleteLinkList {

     public class ListNode1 {
         int val;
         ListNode1 next = null;
         public ListNode1(int val) {
             this.val = val;
        }
     }
    public ListNode1 deleteNode (ListNode1 head, int val) {
        // write code here
        int t ;
        ListNode1 p = head;
        if (p.val == val){
            return head.next;
        }
        while (p.val!=val){
            p = p.next;
        }

        t = p.val;
        p.val = p.next.val;
        p.next.val = t;

        p.next = p.next.next;
        return head;
    }
}
