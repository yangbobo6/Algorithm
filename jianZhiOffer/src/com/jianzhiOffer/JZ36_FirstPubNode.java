package com.jianzhiOffer;

import java.util.HashSet;

//寻找第一个公共节点
//第一个参数{1,2,3}代表是第一个链表非公共部分，第二个参数{4,5}代表是第二个链表非公共部分，最后的{6,7}表示的是2个链表的公共部分
//        这3个参数最后在后台会组装成为2个两个无环的单链表，且是有公共节点的
public class JZ36_FirstPubNode {

    //双指针法    将两个链表合并  再求
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
            if(p1 != p2){
                if(p1 == null)p1 = pHead2;
                if(p2 == null)p2 = pHead1;
            }
        }
        return p1;

    }

    
    //用 hashset解决
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set = new HashSet<>();
        while(pHead1!=null){
            set.add(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2!=null){
            if(set.contains(pHead2)){
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }
}
