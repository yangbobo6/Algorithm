package bit;

/**
 * @Author: yangbo
 * @Date: 2022-06-01-21:43
 * @Description:  位运算 或者 除以2取模  比较各个位数
 */
public class code461_hammingDistance {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while(x!=0||y!=0){
            if(x%2!=y%2){
                count++;
            }
            x = x/2;
            y = y/2;
        }
        return count;
    }
}
