package string;

import java.util.Stack;

/**
 * @Author: yangbo
 * @Date: 2022-02-25-20:53
 * @Description:  栈的进出
 */
public class code20_isValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
                /*
                1、如果是反括号，并且stack里面为空
                2、} 】 ）
                * */
            }else if(stack.isEmpty()||c=='}'&&stack.pop()!='{'||c==']'&&stack.pop()!='['||c==')'&&stack.pop()!='('){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
