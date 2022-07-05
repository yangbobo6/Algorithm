package top101.linklist;

import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-06-27-22:39
 * @Description:  指定区间反转
 */
public class BM2_reverseBetween {
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        //h 新建的头节点   pre指向前一个结点  s,nex只想后一个节点
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h;
        ListNode s = head;
        ListNode nex = head;
        
        //循环停留到第m个之前
        int i = 1;
        while (i<m){
            pre = pre.next;
            s = s.next;
            nex = nex.next;
            i++;
        }
        
        //pre指向空  
        pre.next = null;
        
        //开始后面m-n节点的反转
        while (i<=n){
            nex = nex.next;
            s.next = pre.next;
            pre.next = s;
            s = nex;
            i++;
        }
        
        //和n后面的连接起来
        int step = n-m+1;
        while (step!=0){
            pre = pre.next;
            step--;
        }
        pre.next = s;
        
        //注意返回 h.next，不是head
        return h.next;
    }
        
}
