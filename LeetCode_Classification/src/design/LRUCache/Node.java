package design.LRUCache;

/**
 * @Author: yangbo
 * @Date: 2022-06-04-11:44
 * @Description: lru结构  节点信息
 */
public class Node {
    public int key,val;
    public Node next,prev;
    public Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}
