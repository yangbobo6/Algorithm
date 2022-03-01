package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yangbo
 * @Date: 2022-03-01-21:46
 * @Description:
 */
public class code17_letterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits.length()==0){
            return combinations;
        }
        Map<Character,String> phoneMap = new HashMap<Character,String>(){
            {
                put('2',"abc");
                put('3',"def");
                put('4',"ghi");
                put('5',"jkl");
                put('6',"mno");
                put('7',"pqrs");
                put('8',"tuv");
                put('9',"wxyz");
            }
        };
        backtrack(combinations,phoneMap,digits,0,new StringBuffer());
        return combinations;
    }
    public void backtrack(List<String> combinations,Map<Character,String > phoneMap,String digits,int index,StringBuffer combination){
        if(index == digits.length()){
            combinations.add(combination.toString());
        }else {
            //取出第几个数字  例如  “23”  取出2
            char digit = digits.charAt(index);
            //2 代表abc
            String letters = phoneMap.get(digit);
            int lengthCount = letters.length();
            for (int i = 0; i < lengthCount; i++) {
                //依此取出  abc   第一个循环取出a，添加到stringBuffer
                combination.append(letters.charAt(i));
                backtrack(combinations,phoneMap,digits,index+1,combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
