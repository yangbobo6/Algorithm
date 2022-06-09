package stack;

import java.util.LinkedList;

/**
 * @Author: yangbo
 * @Date: 2022-06-07-21:54
 * @Description:
 */
public class code394_decodeString {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int muti = 0;
        LinkedList<Integer> stack_num = new LinkedList<>();
        LinkedList<String> stack_char = new LinkedList<>();

        for (char c:s.toCharArray()
             ) {
            if(c=='['){
                stack_num.addLast(muti);
                stack_char.addLast(res.toString());
                muti = 0;
                res = new StringBuilder();
            }
            else if(c==']'){
                StringBuilder temp = new StringBuilder();
                int cur_muti = stack_num.removeLast();
                for(int i=0;i<cur_muti;i++){
                    temp.append(res);
                }
                res = new StringBuilder(stack_char.removeLast()+temp);
            }
            else if(c>='0'&&c<='9'){
                //如果大于9  则是多位数  需要*10
                muti = muti*10+Integer.parseInt(c+"");
            }
            else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
