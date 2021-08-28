package com.jianzhiOffer;

import java.util.HashSet;

public class JZ55_LinkListLoop {

    //查看链表中 是否有环，有过有，把环的开始指针节点返回  注意判断p没有换的书写
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = pHead;
        while (set.add(p)&&p!=null){
            p = p.next;
        }
        return p;
    }
}
