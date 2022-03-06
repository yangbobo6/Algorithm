package linklist;

/**
 * @Author: yangbo
 * @Date: 2022-03-06-18:40
 * @Description: 合并两个有序链表
 *
 * 1.先找到
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class code21_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }

        ListNode p = new ListNode();
        ListNode h = p;
        while (list1!=null&&list2!=null){
            if(list1.val> list2.val){
                h.next = list2;
                list2 = list2.next;
            }else {
                h.next = list1;
                list1 = list1.next;
            }
            h = h.next;
        }

        if (list1==null){
            h.next = list2;
        }
        if (list2==null){
            h.next = list1;
        }
        return p.next;
    }
}
