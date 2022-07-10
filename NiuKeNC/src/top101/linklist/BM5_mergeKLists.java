package top101.linklist;

import java.util.ArrayList;

/**
 * @Author: yangbo
 * @Date: 2022-07-10-21:31
 * @Description:  合并k个有序的链表  
 * 
 * 思路： 两个两个的合并
 */
public class BM5_mergeKLists {
    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        merge(lists,0,lists.size()-1);
        return null;
    }
    
    public ListNode merge(ArrayList<ListNode> lists,int l,int r){
        // 左右相等说明不能再分
        if(l==r){
            return lists.get(l);
        }
        if (l>r){
            return null;
        }
        int mid = (l+r)/2;
        return mergeTwoLists(merge(lists,l,mid),merge(lists,mid+1,r));
    }
    
    
    
    
    
    //题解1  先合并两个，在依此合并
    public ListNode mergeKLists1(ArrayList<ListNode> lists) {
        int size = lists.size();
        if(size==0){
            return null;
        }
        
        ListNode head1 = lists.get(0);
        for (int i = 1; i < size; i++) {
            ListNode head2 = lists.get(i);
            head1 = mergeTwoLists(head1,head2);
        }
        return head1;
    }
    
    //merge two lists
    public ListNode mergeTwoLists(ListNode head1,ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode h = dummy;
        while (head1!=null&&head2!=null){
            if(head1.val<head2.val){
                h.next = head1;
                head1 = head1.next;
            }else {
                h.next = head2;
                head2 = head2.next;
            }
            h = h.next;
        }
        
        if (head1==null){
            h.next = head2;
        }else {
            h.next = head1;
        }
        return dummy.next;
        
    }
}
