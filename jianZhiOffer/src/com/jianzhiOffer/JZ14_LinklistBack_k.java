package com.jianzhiOffer;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

//输入一个链表，输出一个链表，该输出链表包含原链表中从倒数第k个结点至尾节点的全部节点。
//如果该链表长度小于k，请返回一个长度为 0 的链表。

public class JZ14_LinklistBack_k {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        int length = 0; int n;
        ListNode p = pHead;
        //先求出链表长度
        while(p!=null){
            p = p.next;
            length++;
        }
        //确定在倒数k 输出链表
        p = pHead;
        n = length - k + 1;
        if(n>0){
            for(int i = 1;i < n;i++){
                p = p.next;
            }
            return p;
        }
        else{
            return null;
        }
    }

    /**
     * 双指针法
     * 初始化两个指针p和q， p指向头结点， q指向头结点后的第k-1个结点, 即第k个结点。
     * 然后开始遍历链表，当q到达尾结点时，返回p。
     * Tip：如果是不带头指针的链表，q一开始应指向第k个结点。
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    ListNode FindKthToTail1(ListNode pHead, int k) {
        if (pHead == null || k <= 0) {
            return null;
        }

        int i;
        ListNode p = pHead, q = pHead;
        for (i = 1; i < k && q.next != null; i++) {
            q = q.next;
        }
        if (i < k) {
            return null;
        }

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }

        return p;
    }
}



