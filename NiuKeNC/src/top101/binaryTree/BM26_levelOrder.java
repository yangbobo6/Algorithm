package top101.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: yangbo
 * @Date: 2022-07-13-21:28
 * @Description:  层序遍历，分层打印每层的数据   
 */
public class BM26_levelOrder {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        //之字形打印二叉树
        if(pRoot==null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(pRoot);
        //主要依靠flag来判断 是正序还是倒序输出
        boolean flag = true;

        while (!deque.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = deque.size();
            while (size!=0){
                //主要 队列入队出队的顺序
                if(flag){
                    TreeNode node=deque.removeFirst();
                    list.add(node.val);
                    if(node.left!=null)
                        deque.addLast(node.left);
                    if(node.right!=null)
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
            flag = !flag;
        }
        return lists;
    }
}
