package linklist;

import java.util.Stack;

/**
 * @Author: yangbo
 * @Date: 2022-03-06-20:38
 * @Description:   回文链表   双指针   hashmap
 */
public class code234_isPalindrome {

    //最坏写法  空间复杂度  申请一个栈
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p!=null){
            stack.push(p.val);
            p = p.next;
        }

        while (!stack.isEmpty()){
            if(stack.pop()!=head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //申请栈   双指针写法  需要n/2个额外空间
    public boolean isPalindrome1(ListNode head) {
        //只包含0个或者1个的时候
        if(head==null||head.next==null){
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        //s为 单步遍历，f为双步遍历
        ListNode s = head;
        ListNode f = head;

        while (f.next!=null&&f.next.next!=null){
            s = s.next;
            f = f.next.next;
        }

        f = s.next;
        s = head;

        while (f!=null){
            stack.push(f.val);
            f = f.next;
        }

        while (!stack.isEmpty()){
            if(s.val!=stack.pop()){
                return false;
            }
            s = s.next;
        }
        return true;
    }
}
