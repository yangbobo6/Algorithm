package top101.stack_queue_heap;

import java.util.Stack;

/**
 * @Author: yangbo
 * @Date: 2022-07-17-18:12
 * @Description:  栈  获得最小的元素
 */
public class BM43_minValueInStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        
        stack1.push(node);
        if(stack2.isEmpty()){
            stack2.push(node);
        }else {
            if(node<stack2.peek()){
                stack2.push(node);
            }else {
                stack2.push(stack2.peek());
            }
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack2.peek();
    }

    public int min() {
        return stack2.peek();
    }

    
}
