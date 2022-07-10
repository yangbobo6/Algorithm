package top101.linklist;

import org.w3c.dom.Node;

/**
 * @Author: yangbo
 * @Date: 2022-07-10-14:14
 * @Description:  删除重复的元素
 * 
 * 画链表解决----
 */
public class BM16_deleteDuplicates {
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if(head == null){
            return head;
        }

        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h;
        ListNode s = head;
        ListNode nex = head;
        int flag = 0;  //巧用flag标记，解决{1，2，2，2}问题，删除最后一个2

        //循环队列，nex.next  不为null
        while (nex!=null){
            nex = nex.next;
            //边界条件，多次试探
            while (nex!=null && nex.val == s.val ){
                pre.next = s.next;
                s = nex;
                nex = nex.next;
                flag = 1;
            }
            if(flag==1){
                pre.next = s.next;
                s = nex;
                flag = 0;
            }else{
                s = s.next;
                pre = pre.next;
            }
        }
        return h.next;
    }
}
