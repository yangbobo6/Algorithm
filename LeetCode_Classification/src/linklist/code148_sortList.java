package linklist;

/**
 * @Author: yangbo
 * @Date: 2022-04-08-15:46
 * @Description:  排序链表  归并排序方法
 */
public class code148_sortList {
    public ListNode sortList(ListNode head) {
        return sortList(head,null);
    }
    
    public ListNode sortList(ListNode head,ListNode tail){
        if(head==null){
            return head;
        }
        if(head.next==tail){
            head.next = null;
            return head;
        }
        ListNode fast = head,slow = head;
        while (fast!=tail){
            fast = fast.next;
            slow = slow.next;
            if(fast!=tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head,mid);
        ListNode list2 = sortList(mid,tail);
        ListNode sorted = merge(list1,list2);
        return sorted;
    }
    
    
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode head = new ListNode(0);
        ListNode temp = head;
        ListNode temp1 = head1,temp2 = head2;
        while (temp1!=null&&temp2!=null){
            if(temp1.val> temp2.val){
                temp.next = temp2;
                temp2 = temp2.next;
            }else {
                temp.next = temp1;
                temp1 = temp1.next;
            }
            temp = temp.next;
        }
        
        if(temp1!=null){
            temp.next = temp1;
        }else if(temp2!=null){
            temp.next = temp2;
        }
        return head.next;
    }
}
