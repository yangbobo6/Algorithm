import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * 整数反转
 * 100 -> 1
 * 123 -> 321
 * -345 -> -543
 * 题解：
 *  123%10 = 3
 *  123/10 = 12
 *  边界：
 *  1/10 = 0
 *  特殊情况  0在末尾
 *  120%10 = 0  如果前几次余数为0 舍弃
 */

public class leetCode_007 {
    public static void main(String[] args) {
        int a = reserve(-123);
        System.out.println(a);
    }
    public static int reserve(int x){
        if(x==0){
            return 0;
        }
        int num = Math.abs(x);
        Stack<Integer> stack = new Stack<>();
        int a;
        int reNum = 0;
        int i = 0;
        while(num!=0){
            a = num%10;
            stack.push(a);
            num /= 10;
        }
        while (!stack.isEmpty()){
            if (reNum>214748364 || (reNum==214748364 && stack.pop()>7)) {
                return 0;
            }
            reNum += stack.pop()*Math.pow(10,i);
            i++;
        }
        if(x>0){
            return reNum;
        }
        return -reNum;
    }

}
