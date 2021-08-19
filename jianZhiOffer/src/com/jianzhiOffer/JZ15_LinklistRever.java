package com.jianzhiOffer;

//无头结点反转链表  *******

import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
//将链表反向指向
public class JZ15_LinklistRever {
    public ListNode ReverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode cur_next;
        while(cur!=null){
            cur_next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur_next;
        }
        return pre;
    }
//    辅助栈解决
//    public ListNode ReverseList(ListNode head) {
//        Stack<Integer> stack=new Stack<>();
//        ListNode newNode=new ListNode(0);
//        ListNode temp=newNode;
//        while(head!=null){
//            stack.push(head.val);
//            head=head.next;
//        }
//        while(!stack.isEmpty()){
//            temp.next=new ListNode(stack.pop());
//            temp=temp.next;
//        }
//        return newNode.next;
//    }
}


