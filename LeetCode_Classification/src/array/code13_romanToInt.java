package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangbo
 * @Date: 2022-04-18-10:03
 * @Description:
 */
public class code13_romanToInt {
    public static void main(String[] args) {
        code13_romanToInt c = new code13_romanToInt();
        String s = "MCMXCIV";
        int a = c.romanToInt(s);
        System.out.println(a);
        
    }
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] ch = s.toCharArray();
        int len = ch.length;
        int sum=0;
        for (int i = 0; i < len; i++) {
            if(i<len-1){
                if (ch[i] == 'I' && (ch[i + 1] == 'V' || ch[i + 1] == 'X')) {
                    sum -= map.get(ch[i]);
                    continue;
                }
                if (ch[i] == 'X' && (ch[i + 1] == 'L' || ch[i + 1] == 'C')) {
                    sum -= map.get(ch[i]);
                    continue;
                }
                if (ch[i] == 'C' && (ch[i + 1] == 'D' || ch[i + 1] == 'M')) {
                    sum -= map.get(ch[i]);
                    continue;
                }
            }
            sum += map.get(ch[i]);
        }
        return sum;
    }
}
