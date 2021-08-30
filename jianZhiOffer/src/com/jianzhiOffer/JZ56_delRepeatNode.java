package com.jianzhiOffer;

public class JZ56_delRepeatNode {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode p = pHead;
        ListNode r = pHead.next;
        if(pHead.next==null){
            return pHead;
        }
        while (p.next!=null){
            if(p.val!=r.val){
                p = p.next;
                r = r.next;
            }
            while (p.val==r.val){
                r =r.next;
                if(p.val!=r.val){
                    int temp = r.val;
                    r.val = p.val;
                    p.val = temp;
                    p.next = r.next;
                    r = r.next;
                }
            }

        }
        return pHead;
    }
}
