package design;

import java.util.*;

/**
 * @Author: yangbo
 * @Date: 2022-06-02-22:07
 * @Description:  设计LRU缓存
 */
public class code146_LRUCache {
    private int cap;
    private Map<Integer, List<Integer>> hashmap ;
    //private int priority;
    private int index;

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public Map<Integer, List<Integer>> getHashmap() {
        return hashmap;
    }

    public void setHashmap(Map<Integer, List<Integer>> hashmap) {
        this.hashmap = hashmap;
    }

    public code146_LRUCache(int capacity){
        this.cap = capacity;
        hashmap = new HashMap<>();
        
    }
    
    public int get(int key){
        if(hashmap.containsKey(key)){
            return hashmap.get(key).get(0);
        }else {
            return -1;
        }
    }
    
    public void set(int key,int value){
        if(hashmap.containsKey(key)){
            hashmap.get(key).set(value,cap);
        }else {
            
            if(hashmap.size()>=cap){
                for (Map.Entry<Integer,List<Integer>> entry:hashmap.entrySet()
                ) {
                    int min = cap+1;
                    
                    if(min>entry.getValue().get(1)){
                        this.index= entry.getKey();
                        min = entry.getValue().get(1);
                    }
                    
                }
                hashmap.remove(this.index);
            }
            List<Integer> list = new ArrayList<>();
            list.add(value);
            list.add(cap);
            hashmap.put(key,list);
        }
        for (Map.Entry<Integer,List<Integer>> entry:hashmap.entrySet()
             ) {
            if(entry.getKey()!=key){
                int val = entry.getValue().get(1)-1;
                entry.getValue().set(1,val);
            }
        }
    }

    public static void main(String[] args) {
        code146_LRUCache cache = new code146_LRUCache(2);
        cache.set(1,1);
        cache.set(2,2);
        cache.set(3,3);
        System.out.println(cache.getHashmap().get(3));
        System.out.println(cache.getHashmap().get(2));
    }
    
}
