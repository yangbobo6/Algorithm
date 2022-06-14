package string;

/**
 * @Author: yangbo
 * @Date: 2022-06-13-22:01
 * @Description: 回文数
 */
public class code9_isPalindrome {
    public boolean isPalindrome(int x) {
        String s = new StringBuilder(x+"").reverse().toString();
        return (x+"").equals(s);
    }
}
