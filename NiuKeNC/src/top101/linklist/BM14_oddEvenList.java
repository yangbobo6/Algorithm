package top101.linklist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-07-10-15:01
 * @Description:
 * 
 *   将一个链表的 奇偶 分开，然后输出
 */
public class BM14_oddEvenList {
    
    
    
    
    
    
    
    
    
    
    
    
    //利用列表分 奇偶，
    public ListNode oddEvenList (ListNode head) {
        // write code here
        if(head == null){
            return head;
        }
        ListNode h=head; 
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int flag = 1;
        while (h != null){
            if(flag%2 != 0){
                list1.add(h.val);
            }else {
                list2.add(h.val);
            }
            flag++;
            h = h.next;
        }
        System.out.println(list1);
        
        h = head;
        for (int i = 0; i < list1.size(); i++) {
            h.val = list1.get(i);
            h = h.next;
        }

        for (int i = 0; i < list2.size(); i++) {
            h.val = list1.get(i);
            h = h.next;
        }
        
        return head;
    }
}
