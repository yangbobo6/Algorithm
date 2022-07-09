package top101.linklist;

import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-07-08-22:15
 * @Description:  链表中倒数第k个节点  快慢指针  快指针先走n步
 */
public class BM8_FindKthToTail {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        for(int i = k;i>1;i--){
            //判断条件很重要
            if (fast==null){
                return null;
            }
            fast = fast.next;
            
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
        
    }
}
