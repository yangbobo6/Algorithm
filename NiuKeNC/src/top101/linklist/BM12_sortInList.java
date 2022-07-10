package top101.linklist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-07-09-18:49
 * @Description: 单链表的排序
 */
public class BM12_sortInList {
    //
    public ListNode sortInList (ListNode head) {
        // write code here
        List<Integer> list =new ArrayList<>();
        ListNode h = head;
        while (h!=null){
            list.add(h.val);
            h = h.next;
        }
        Collections.sort(list);
        h = head;
        int i = 0;
        while (h!=null){
            h.val = list.get(i);
            i++;
            h = h.next;
        }
        
        return head;
    }
}
