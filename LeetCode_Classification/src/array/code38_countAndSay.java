package array;

/**
 * @Author: yangbo
 * @Date: 2022-04-25-22:06
 * @Description:  
 */
public class code38_countAndSay {
    public String countAndSay(int n) {
        String str = "1";
        for(int i = 2;i<=n;i++){
            StringBuilder stringBuilder = new StringBuilder();
            int start = 0;
            int pos = 0;
            while(pos < str.length()){
                while(pos<str.length() && str.charAt(pos) == str.charAt(start)){
                    pos ++;
                }
                stringBuilder.append(Integer.toString(pos-start)).append(str.charAt(start));
                start = pos;
            }
            str = stringBuilder.toString();
        }
        return str;
    }
}
