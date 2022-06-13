package array;

import java.util.Arrays;

/**
 * @Author: yangbo
 * @Date: 2022-06-11-11:30
 * @Description:
 */
public class code739_dailyTemperatures {
    
    //双循环解决
    int index;
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Arrays.fill(ans,0);
        int flag = 0;
        for(int i =0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(temperatures[j]>temperatures[i]){
                    flag = 1;
                    index = j;
                    break;
                }
            }
            if (flag==1){
                ans[i] = index-i;
            }
            flag = 0;
        }
        return ans;
    }
    

    public static void main(String[] args) {
        code739_dailyTemperatures c = new code739_dailyTemperatures();
        int[] temperatures = new int[]{34,80,80,34,34,80,80,80,80,34}; 
        c.dailyTemperatures(temperatures);
    }
}
