package com.jianzhiOffer;

import java.util.ArrayList;
import java.util.Stack;

//利用两个栈实现
public class JZ59_zhiPrintBinary {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int flag = 1;
        stack1.push(pRoot);
        while (!stack1.isEmpty()&&!stack2.isEmpty()){
            while (flag%2!=0){
                TreeNode t1 ;
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack1.isEmpty()){
                    t1 = stack1.pop();
                    list.add(t1.val);
                    stack2.push(t1.left);
                    stack2.push(t1.right);
                }
                lists.add(list);
                flag++;
            }
            while (flag%2==0){
                TreeNode t2 ;
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack1.isEmpty()){
                    t2 = stack1.pop();
                    list.add(t2.val);
                    stack2.push(t2.right);
                    stack2.push(t2.left);
                }
                lists.add(list);
                flag++;

            }
        }
        return lists;

    }
}
