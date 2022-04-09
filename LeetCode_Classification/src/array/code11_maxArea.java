package array;

/**
 * @Author: yangbo
 * @Date: 2022-04-09-20:27
 * @Description:
 */
public class code11_maxArea {
    public int maxArea(int[] height) {
        int n = height.length-1;
        int m = 0;
        int max = 0;
        while(n>m){
            int area = Math.min(height[m],height[n])*(n-m);
            max = Math.max(area,max);
            if (height[m] > height[n]) {
                n--;
            } else {
                m++;
            }
        }
        return max;
    }
}
