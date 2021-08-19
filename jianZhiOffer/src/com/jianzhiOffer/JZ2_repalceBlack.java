package com.jianzhiOffer;


//替换空格  将we are young   变为 we%20are%20young   考察stringBuilder的使用
public class JZ2_repalceBlack {
    public String replaceSpace (String s) {
        // write code here
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                str.append("%20");
            }else{
                str.append(s.charAt(i));
            }
        }
        return str.toString();

    }
}
