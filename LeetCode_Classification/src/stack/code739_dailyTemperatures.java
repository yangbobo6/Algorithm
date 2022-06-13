package stack;

import java.util.Stack;

/**
 * @Author: yangbo
 * @Date: 2022-06-11-15:32
 * @Description:
 */
public class code739_dailyTemperatures {
 
    public int[] dailyTemperatures(int[] temperatures) {
        //栈里面存储的是温度数组的序号
        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int[] res = new int[len];
        
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                int pre = stack.pop();
                res[pre] = i-pre;
            }
            stack.add(i);
        }
        return res;
    }
}
