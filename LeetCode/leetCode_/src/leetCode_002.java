
 //Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
//数组越界不能处理   方法不正确！！！！！
public class leetCode_002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long i = 0;
        long sum=0;
        long num1 = calNumber(i,sum,l1);
        long num2 = calNumber(i,sum,l2);
        long add = num1+num2;

        ListNode head = new ListNode();
        ListNode p = head;
        //溢出  add大于10的9次方
        head.val = (int)(add%10);
        add = add/10;
        while (add!=0){
            ListNode s = new ListNode();
            s.next = null;
            s.val = (int) (add%10);
            add = add/10;
            p.next = s;
            p = p.next;
        }
        return head;

    }
    public long calNumber(long i,long sum,ListNode l){
        long val;
        while (l!=null){
            val = (long) (l.val*Math.pow(10,i));
            i++;
            sum = sum+val;
            l=l.next;
        }
        return sum;
    }
}
