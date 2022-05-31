package stack;

import java.util.Stack;

/**
 * @Author: yangbo
 * @Date: 2022-05-30-22:33
 * @Description:
 */
public class code155_MinStack {
    //数据栈
    private Stack<Integer> data;
    //辅助栈
    private Stack<Integer> helper;
    
    public code155_MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int val) {
        data.add(val);
        //空 或者 val比较小
        if(helper.isEmpty()||helper.peek()>=val){
            helper.add(val);
        }else {
            helper.add(helper.peek());
        }
    }

    public void pop() {
        if(!data.isEmpty()){
            helper.pop();
            data.pop();
        }
    }

    public int top() {
        if(!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if(!helper.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}
