package design.LRUCache;

/**
 * @Author: yangbo
 * @Date: 2022-06-04-11:46
 * @Description:  根据node构建双链表
 * 
 * 注意  
 * 我们实现的双链表 API 只能从尾部插入，
 * 也就是说靠尾部的数据是最近使用的，
 * 靠头部的数据是最久为使用的
 */
public class DoubleList {
    //头节点 和 尾节点
    private Node head,tail;
    //size
    private int size;
    public DoubleList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    //在链表尾部添加节点
    public void addLast(Node x){
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }
    //删除链表中x的节点
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size --;
    }
    //删除链表的第一个节点，并返回该节点
    public Node removeFirst(){
        if(head.next == tail){
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }
    public int size(){
        return size;
    }
    
    
        
}
