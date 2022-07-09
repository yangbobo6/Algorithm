package top101.linklist;

/**
 * @Author: yangbo
 * @Date: 2022-07-08-22:34
 * @Description:  删除倒数第n个节点   有坑！！！
 * 
 * 先找出 要删除的前一个节点  pre
 * 注意： 如果删除了头节点的话，就不能返回head了，需要返回pre.next
 */
public class BM9_removeNthFromEnd {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        int count = 1;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast = head;
        ListNode slow = head;
        //先走 n步
        for (int i = n; i > 1 ; i--) {
            fast = fast.next;
            count++;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
            count++;
        }
        
        pre.next = slow.next;
        if(n==count){
            return pre.next;
        }
        return head;
    }
}
