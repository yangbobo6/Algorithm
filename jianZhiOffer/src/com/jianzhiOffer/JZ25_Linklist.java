package com.jianzhiOffer;

import java.util.HashMap;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
//利用hashmap存值  来连接randam
public class JZ25_Linklist {
    public RandomListNode Clone(RandomListNode pHead) {
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode p = pHead;
        while (p!=null){
            map.put(p,new RandomListNode(p.label));
            p = p.next;
        }
        p = pHead;
        while (p!=null){
            //获取 上面创建的 新节点
            map.get(p).next = map.get(p.next);
            p = p.next;
        }
        RandomListNode resHead = map.get(pHead);
        p = pHead;
        while (p!=null){
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return resHead;
    }
}
