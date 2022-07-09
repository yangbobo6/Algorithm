package top101.linklist;

import org.w3c.dom.Node;

/**
 * @Author: yangbo
 * @Date: 2022-07-08-23:30
 * @Description: 链表相加 
 * 
 * 思路： 1.比较两个链表的长度，用于将长的链表作为要最终的链表
 *       2.将链表反转
 *       3，两个链表相加，
 *       4.边界值判断（难点）  
 *       5.再次将结果反转
 */
public class BM11_addInList {
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        
        //求出链表的长度，将head1设置为最长的链表
        int len1 = 0;
        int len2 = 0;
        len1 = length(head1,len1);
        len2 = length(head2,len2);
        if(len1<len2){
            ListNode node = head1;
            head1 = head2;
            head2 = node;
        }
        
        //反转链表
        head1 = reverseLinklist(head1);
        head2 = reverseLinklist(head2);
        
        
        int sum = 0;
        int add = 0;
        //相加公共链表，注意满10进1，用取余和参数标志add 来表示构造加一步骤
        ListNode h = head1;
        while (head2!=null){
            sum = head1.val + head2.val+add;
            if(sum>=10){
                head1.val = sum%10;
                //需要下一位 +1
                add = 1;
            }else {
                head1.val = sum;
                add = 0;
            }
            
            head1 = head1.next;
            head2 = head2.next;
        }
        
        //最后一位，如果add为一，进一，需要创建节点，需要知道前一位的指针
        ListNode lastPre = null;
        while (add == 1 && head1!=null){
            //得到倒数第一个指针
            if(head1.next == null){
                lastPre = head1;
            }
            //满10进1的思想
            sum = head1.val+add;
            if(sum >=10){
                head1.val = sum%10;
                add = 1;
            }else {
                head1.val = sum;
                add =0;
            }
            head1 = head1.next;
        }
        //如果head为null，但是add还是1，说明需要进位，则要创建新的节点
        if (head1==null&&add==1){
            lastPre.next = new ListNode(1);
        }
        
        //将链表反转
        ListNode ans = reverseLinklist(h);
        return ans;
    }
    
    //返回链表的长度
    public int length(ListNode h,int len){
        while (h!=null){
            h = h.next;
            len++;
        }
        return len;
    }
    
    
    //头插法  将链表反转
    public ListNode reverseLinklist(ListNode head){
        ListNode h = new ListNode(0);
        h.next = null;
        ListNode nex = head;
        while(head!=null){
            nex = nex.next;
            head.next = h.next;
            h.next = head;
            head = nex;
        }
        return h.next;
    }
    
}
