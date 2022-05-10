package dp;

/**
 * @Author: yangbo
 * @Date: 2022-05-06-22:47
 * @Description:  最长回文数  babad   bab或者aba  
 */
public class code5_longestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len == 1){
            return s;
        }
        //最大长度
        int maxLen = 1;
        //从哪里开始截取
        int begin = 0;
        char[] charArray = s.toCharArray();
        
        for(int i=0;i<len-1;i++){
            for (int j = i; j < len; j++) {
                //当下标差值大于最大值
                if(j-i+1>maxLen&&validPalindromic(charArray,i,j)){
                    maxLen = j-i+1;
                    begin = i;
                    
                }
                
            }
        }
        return s.substring(begin,begin+maxLen);
    }
    
    private boolean validPalindromic(char[] charArray,int left,int right){
        while(left<right){
            if(charArray[left]!=charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
        
    }
}
