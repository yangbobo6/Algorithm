package com.jianzhiOffer;
//  难  指针的变化
public class JZ56_delRepeatNode {

    public ListNode buildLinkList(){
        int [] array = new int[]{1,2,3,3,4,4,5};
        ListNode pHead = new ListNode(array[0]);
        ListNode p = pHead;
        for (int i = 1; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            node.next = p.next;
            p.next = node;
            p = p.next;
        }
        p = pHead;
        while (p!=null){
            System.out.println(p.val);
            p = p.next;
        }
        return pHead;
    }


    public ListNode deleteDuplication(ListNode pHead) {
        ListNode q, p, r;
        p = pHead;
        q = r = null;

        while (p != null) {
            boolean flag = false;
            r = p.next;
            while (r != null && r.val == p.val) {
                flag = true;
                r = r.next;
            }
            if (flag) {
                if (q != null)
                    q.next = r;
                else
                    pHead = null;
            } else {
                if (q == null)
                    pHead = p;
                q = p;
            }
            p = r;
        }

        return pHead;
    }

    public static void main(String[] args) {
        JZ56_delRepeatNode jz56_delRepeatNode = new JZ56_delRepeatNode();
        ListNode pHead = jz56_delRepeatNode.buildLinkList();
        ListNode listNode = jz56_delRepeatNode.deleteDuplication(pHead);
        while (listNode!=null){
            System.out.println(listNode.val);
        }
    }
}
