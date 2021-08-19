package com.jianzhiOffer;
import java.util.ArrayList;
import java.util.Stack;

public class JZ3_LinklistReverArray {

    class ListNode {
        int val;
        ListNode next = null;
        ListNode(){}
        ListNode(int val) {
            this.val = val;
        }
    }
    //将链表转置  *********
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //头插法转置链表
        ArrayList<Integer> list = new ArrayList<>();
        ListNode node = new ListNode(0);
        ListNode n = listNode;
        while(listNode!=null){
            listNode = listNode.next;
            n.next = node.next;
            node.next = n;
            list.add(0,n.val);
            n = listNode;
        }
        return list;
    }

    //递归方法倒序输出内容
//    ArrayList<Integer> list = new ArrayList();
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        if(listNode!=null){
//            printListFromTailToHead(listNode.next);
//            list.add(listNode.val);
//        }
//        return list;
//    }

        //利用栈   先进后出
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        Stack<Integer> sc = new Stack<>(); //栈是先进后出
//        while(listNode != null){ //若当前ListNode类对象不为空
//            sc.push(listNode.val);//则将当前对象的头节点存入栈中
//            listNode = listNode.next; //将当前对象的下一个节点对象赋给listNode对象，对象传对象
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        while(!sc.isEmpty()){  //若当前的栈内存不为空
//            list.add(sc.pop());//出栈，先进后出，即先输出后进来的
//        }
//        return list;
//    }


}
