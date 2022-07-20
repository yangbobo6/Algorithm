package top101.stack_queue_heap;

import java.util.Stack;

/**
 * @Author: yangbo
 * @Date: 2022-07-17-17:38
 * @Description:
 */
public class BM42_Queue {
    Stack<Integer> stack1 = new Stack<>(); 
    Stack<Integer> stack2 = new Stack<>();
    
    public void push(int node){
        stack1.push(node);
    }
    
    public int pop(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            
        }
        return stack2.pop();
    }
}
