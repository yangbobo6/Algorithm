import java.util.Arrays;

/**
 * @Author: yangbo
 * @Date: 2022-03-02-20:44
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        String str = "yangBo";
        char[] ch = str.toCharArray();
        System.out.println(ch);
        Arrays.sort(ch);
        System.out.println(ch);
    }
}
