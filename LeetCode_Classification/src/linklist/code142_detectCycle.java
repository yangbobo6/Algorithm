package linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yangbo
 * @Date: 2022-04-08-14:46
 * @Description:  判断是否有环，并返回第一个节点
 */
public class code142_detectCycle {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode > nodeSet = new HashSet<>();
        while(head!=null){
            boolean add = nodeSet.add(head);
            if (!add){
                return head;
            }
            head = head.next;
        }
        return null;
    }
    
    //双指针法   满指针再走a步就是
    public ListNode detectCycle1(ListNode head) {
        //快慢指针
        ListNode f=head,s=head;
        while(true){
            if(f==null||f.next==null){
                return null;
            }
            f = f.next.next;
            s = s.next;
            if(s==f){
                break;
            }
        }
        f = head;
        while (f!=s){
            f = f.next;
            s = s.next;
        }
        return f;
    }
}
