package top101.stack_queue_heap;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: yangbo
 * @Date: 2022-07-17-21:46
 * @Description:
 */
public class BM44_isValid {
    public boolean isValid (String s) {
        // write code here
        Deque<Character> deque = new LinkedList<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        
        for (int i = 0; i < len; i++) {
            if(chars[i]=='('||chars[i]=='{'||chars[i]=='['){
                deque.push(chars[i]);
            }
            if((chars[i]==')'||chars[i]=='}'||chars[i]==']')&&deque.isEmpty()){
                return false;
            }
            

            if(chars[i]==')'){
                Character ch = deque.getFirst();
                if(ch=='('){
                    deque.pop();
                }else {
                    return false;
                }
            }
            if(chars[i]==']'){
                Character ch = deque.getFirst();
                if(ch=='['){
                    deque.pop();
                }else {
                    return false;
                }
            }
            if(chars[i]=='}'){
                Character ch = deque.getFirst();
                if(ch=='{'){
                    deque.pop();
                }else {
                    return false;
                }
            }
        }
        
        if(!deque.isEmpty()){
            return false;
        }
        return true;
    }
}
