package top101.linklist;

/**
 * @Author: yangbo
 * @Date: 2022-07-06-22:10
 * @Description: 每k个反转链表，如果最后一组少于k个，则不反转----
 */
public class BM3_reverseKGroup {
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        
        //变量初始化， h节点为dummyHead，  pre为前一个节点，s为当前节点，nex为后一个节点
        ListNode h = new ListNode(0);
        ListNode pre = h;
        h.next = null;
        ListNode s = head;
        ListNode nex = head;
        ListNode flagNode = head;

        //flag为标志，查看最后一组节点是否满足k个，不满足则不反转。
        int flag = 0;
        int step = k;
        while (s!=null){

            //判断是否为最后一组
            for (int i = 0; i < step; i++) {
                flagNode = flagNode.next;
                //注意边界条件判断
                if(flagNode==null && i!=step-1){
                    flag = 1;
                    break;
                }
            }
            if(flag==1){
                pre.next = s;
                break;
            }
            
            //除最后一组，其他组正常作 链表反转，采用头插法来做反转
            while (step!=0){
                nex = nex.next;
                s.next = pre.next;
                pre.next = s;
                s = nex;
                step --;
            }
            //反转结束后，pre节点要成为下一组的头节点
            for (int i = 0; i < k; i++) {
                pre = pre.next;
            }
            step = k;
        }
        return h.next;
    }
}
