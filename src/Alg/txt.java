package Alg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author zhangsan
 * @date 2021-05-31 21:08
 */
public class txt {
    public static Integer txt2String(File file) {
        String result = "";
        int count=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = br.readLine()) != null) {
                result = result + s;
            }
            char[] chars = result.toCharArray();
            for (char aChar : chars) {
                if (('a' <= aChar && 'z' >= aChar) || 'A' <= aChar && 'Z' >= aChar){
                    count++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) {
        File file = new File("D:\\test\\src下test.txt");
        System.out.println(txt2String(file));
    }
}
