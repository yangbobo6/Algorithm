package top101.linklist;

import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-07-06-21:57
 * @Description: 合并两个有序链表
 */
public class BM4_Merge {
    public ListNode Merge(ListNode list1,ListNode list2){
        if(list1==null||list2==null){
            return list1==null?list2:list1;
        }
        //设置头节点
        ListNode h = new ListNode(0);
        ListNode s = h;
        //边界条件  当两个都不为0时候
        while(list1!=null&&list2!=null){
            if(list1.val>list2.val){
                s.next = list2;
                list2 = list2.next;
            }else {
                s.next = list1;
                list1 = list1.next;
            }
            s = s.next;
        }
        
        if(list1 == null){
            s.next = list2;
        }else {
            s.next = list1;
        }
        return h.next;
    }
}
