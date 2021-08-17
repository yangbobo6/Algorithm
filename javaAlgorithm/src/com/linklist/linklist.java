package com.linklist;

//linklist链表的创建   该项目为写在了同一类里面    分开写会怎么样
public class linklist {
    int size = 0;  //链表的长度
    static Node headNode;  //Node类型
    static Node tempNode;
    int i = 0;
    //创建节点的类    ques ：构造方法和get set 怎样写？？
    class Node{
        private int data;
        //指针
        private Node next;
        //无参构造
        Node(){}
        //有参构造
        Node(int data){
            this.data = data;
        }


    }
    //尾插法建立单链表
    public void fun(Node node,int data){
        //创建10个节点
        if(i<=10){
            //新建一个节点
            Node newNode = new Node();
            //数据域
            newNode.data = i;
            //指针域
            newNode.next = null;
            //上一个节点和下一个相连
            node.next = newNode;
            //递归建立
            fun(newNode,++i);
        }
    }
    //头插法简历链表
    public void afterInsert(Node node,int data){
        if(i<=10){
            Node newNode = new Node();
            newNode.data = i;
            //头插法 在头节点后面插入
            newNode.next = node.next;
            node.next = newNode;
            afterInsert(node,++i);
        }
    }

    public static void main(String[] args) {
        linklist list = new linklist();
        //头指针    ques:为什么加list
        headNode = list.new Node();
        tempNode = list.new Node();
        list.fun(headNode,0);
        //new linklist().afterInsert(headNode,0);//后插法
        System.out.println("创建的链表是：");
        while (headNode.next!=null){
            headNode = headNode.next;
            System.out.println(headNode.data+" ||| "+headNode.next);
        }
    }
}
