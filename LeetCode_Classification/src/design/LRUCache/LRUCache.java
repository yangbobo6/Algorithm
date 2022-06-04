package design.LRUCache;

import java.util.HashMap;

/**
 * @Author: yangbo
 * @Date: 2022-06-04-11:42
 * @Description:
 */
public class LRUCache {
    // key -> Node(key, val)
    private HashMap<Integer,Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;
    //最大容量
    private int cap;
    public LRUCache(int cap){
        this.cap = cap;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    
    //将某个key提升为最近常用的(删除节点，加入队尾)
    private void makeRecently(int key){
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }
    //添加最近使用的元素
    private void addRecently(int key,int val){
        Node x = new Node(key,val);
        cache.addLast(x);
        map.put(key,x);
        
    }
    //删除某一个
    private void deleteKey(int key){
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }
    //删除最久没有使用的元素
    private void removeLeastRecently(){
        Node deleteNode = cache.removeFirst();
        map.remove(deleteNode.key);
    }
    
    //获取值
    public int get(int key){
        //不存在  返回-1
        if(!map.containsKey(key)){
            return -1;
        }
        //设置为最新值
        makeRecently(key);
        //返回内容
        return map.get(key).val;
    }
    public void put(int key,int val){
        //如果包含，则更新该值
        if(map.containsKey(key)){
            deleteKey(key);
            addRecently(key,val);
            return;
        }
        //如果达到容量大小，则删除最不常使用的
        if (cap==cache.size()){
            removeLeastRecently();
        }
        //增加最新的
        addRecently(key,val);
    }
}
