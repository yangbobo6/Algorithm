package TreeNode_Model;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author: yangbo
 * @Date: 2022-02-18-20:53
 * @Description:
 */
public class JZ78_Print {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        HashMap<TreeNode ,Integer> hashMap = new HashMap<>();
        if(pRoot==null){
            return lists;
        }
        //双端队列
        Deque<TreeNode> queue = new LinkedList();
        queue.addFirst(pRoot);
        hashMap.put(pRoot,0);
        while(!queue.isEmpty()){
            pRoot = queue.pollLast();
            int deep = hashMap.get(pRoot);
            if (pRoot.left!=null){
                queue.addFirst(pRoot.left);
                hashMap.put(pRoot.left,deep+1);
            }
            if(pRoot.right!=null){
                queue.addFirst(pRoot.right);
                hashMap.put(pRoot.right,deep+1);
            }
            //说明  到了下一层节点  需要重新分配数组
            if(lists.size()<=deep){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(pRoot.val);
                lists.add(list);

            }
            else {
                ArrayList<Integer> list = lists.get(deep);
                list.add(pRoot.val);
            }
        }
        return lists;
    }
}
