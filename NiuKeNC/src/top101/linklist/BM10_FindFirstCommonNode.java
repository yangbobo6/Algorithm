package top101.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yangbo
 * @Date: 2022-07-08-23:10
 * @Description: 两个链表相交，无环单链表，找到相交的第一个节点
 * 
 * 双指针法
 */
public class BM10_FindFirstCommonNode {
    //双指针法  找出长的队列，先走|p1-p2|步，然后再同时走
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        int p1 = 1;
        int p2 = 1;
        ListNode f1 = pHead1;
        ListNode f2 = pHead2;
        while (f1!=null){
            f1 = f1.next;
            p1++;
        }
        while (f2!=null){
            f2 = f2.next;
            p2++;
        }
        int step = Math.abs(p1-p2);
        if(p1>p2){
            while (step!=0){
                pHead1 = pHead1.next;
                step--;
            }
        }else {
            while (step!=0){
                pHead2 = pHead2.next;
                step--;
            }
        }
        while (pHead1!=pHead2){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }
    
    
    
    //hashSet 做法
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> hashSet = new HashSet<>();
        while (pHead1!=null){
            hashSet.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2!=null){
            if (hashSet.contains(pHead2)){
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }
        
}
