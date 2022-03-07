package linklist;

import java.util.HashSet;

/**
 * @Author: yangbo
 * @Date: 2022-03-07-22:19
 * @Description:  判断两个链表是否相交  双指针法
 */
public class code160_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        int a = 0;
        int b = 0;
        while (p.next!=null){
            p = p.next;
            a++;
        }
        while (q.next!=null){
            q = q.next;
            b++;
        }
        if(p!=q){
            return null;
        }
        int count = a - b >=0?(a-b):(b-a);
        //headA 长   先走count步
        if(a-b>=0){
            while (count!=0){
                headA = headA.next;
                count--;
            }
            while (headA!=headB){
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }else {
            while (count!=0){
                headB = headB.next;
                count--;
            }
            while (headA!=headB){
                headA = headA.next;
                headB = headB.next;
            }
            return headB;
        }
    }

    //辅助空间    先将一个链表加入set   在判断另一个是否在里面
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB){
        HashSet set = new HashSet();
        while (headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB!=null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
