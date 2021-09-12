package com.jianzhiOffer;

import java.util.ArrayList;
import java.util.Stack;

//利用两个栈实现
public class JZ59_zhiPrintBinary {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        int flag = 1;
        if(pRoot==null){
            return null;
        }
        stack1.push(pRoot);
        while ((!stack1.isEmpty())||(!stack2.isEmpty())){
            ArrayList<Integer> list = new ArrayList<>();
            if (flag%2!=0){
                TreeNode t1 ;
                while (!stack1.isEmpty()){
                    t1 = stack1.pop();
                    list.add(t1.val);
                    if(t1.left!=null){
                        stack2.push(t1.left);
                    }
                    if(t1.right!=null){
                        stack2.push(t1.right);
                    }
                }
            }
            else{
                TreeNode t2 ;
                while (!stack2.isEmpty()){
                    t2 = stack2.pop();
                    list.add(t2.val);
                    if(t2.right!=null){
                        stack1.push(t2.right);
                    }
                    if(t2.left!=null){
                        stack1.push(t2.left);
                    }
                }
            }
            lists.add(list);
            flag++;
        }
        return lists;
    }
}
