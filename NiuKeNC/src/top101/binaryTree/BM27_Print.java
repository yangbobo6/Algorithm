package top101.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: yangbo
 * @Date: 2022-07-13-21:31
 * @Description:  之字打印 树
 */
public class BM27_Print {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(pRoot);
        boolean flag = true;
        while(!deque.isEmpty()){
            int size = deque.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size!=0){
                
                if(flag==true){
                    TreeNode node = deque.removeFirst();
                    list.add(node.val);
                    if(node.left!=null)
                        deque.addLast(node.left);
                    if (node.right!=null)
                        deque.addLast(node.right);
                }else {
                    TreeNode node = deque.removeLast();
                    list.add(node.val);
                    if (node.right!=null)
                        deque.addFirst(node.right);
                    if (node.left!=null)
                        deque.addFirst(node.left);
                }
                size--;
            }
            lists.add(list);
        }
        return lists;
    }
}
