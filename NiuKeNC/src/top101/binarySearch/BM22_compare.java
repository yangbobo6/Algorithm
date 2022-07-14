package top101.binarySearch;

/**
 * @Author: yangbo
 * @Date: 2022-07-12-21:16
 * @Description:  比较两个版本号的大小**  
 * 
 * 思路： 将版本号按照 . 分开，然后将中间转化位数字比较
 */
public class BM22_compare {
    public int compare (String version1, String version2) {
        // write code here
        int len1 = version1.length();
        int len2 = version2.length();

        int i = 0;
        int j = 0;

        while(i<len1 || j<len2){
            long sum1 = 0;
            while (i<len1&&version1.charAt(i)!='.'){
                sum1 = sum1*10+(version1.charAt(i)-'0');
                i++;
            }
            i++;

            long sum2 = 0;
            while(j<len2&&version2.charAt(j)!='.'){
                sum2 = sum2*10+(version2.charAt(j)-'0');
                j++;
            }
            j++;

            if(sum1>sum2){
                return 1;
            }
            if(sum1<sum2){
                return -1;
            }
        }
        return 0;

    }
    
}
