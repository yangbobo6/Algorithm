package top101.linklist;

import java.util.*;

/**
 * @Author: yangbo
 * @Date: 2022-07-10-10:44
 * @Description: 删除有序链表中重复的元素-I
 * 
 * 已经排好序  ，只需要将
 */
public class BM15_deleteDuplicates {

    public ListNode deleteDuplicates (ListNode head) {
        if(head!=null){
            return head;
        }
        ListNode s = head;
        ListNode nex = head;
        //注意边界条件
        while (nex.next!=null){
            nex = nex.next;
            if (s.val == nex.val){
                s.next = nex.next;
                nex = s;
            }else {
                s = s.next;
            }
        }
        return head;
    }
    
    
    //时间复杂度 低    空间复杂度 底  (set 去重，list 排序)
    public ListNode deleteDuplicates1 (ListNode head) {
        // write code here
        ListNode h = head;
        Set<Integer> set = new HashSet<>();
        while (h!=null){
            set.add(h.val);
            h = h.next;
        }
        
        Iterator<Integer> iterator = set.iterator();
        List<Integer> list = new ArrayList<>();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        Collections.sort(list);
        System.out.println(list.toString());
        
        h = head;
        for (int i = 0; i < list.size(); i++) {
            h.val = list.get(i);
            h = h.next;
        }
        
        int size = list.size();
        System.out.println(size);
        while (size!=1){
            size--;
            h = h.next;
        }
        h.next = null;
        return head;
    }
}
