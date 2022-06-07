package array;

/**
 * @Author: yangbo
 * @Date: 2022-06-06-16:27
 * @Description:
 */
public class code338_countBits {

    public static void main(String[] args) {
        code338_countBits c = new code338_countBits();
        int[] res ;
        res = c.countBits(5);
        for (int n:res
             ) {
            System.out.println("数组为:"+n);
        }
        
    }
    
    public int[] countBits(int n) {
        if(n==0){
            return new int[]{0};
        }
        int[] res = new int[n+1];
        res[0] = 0;
        for(int i = 1;i<=n;i++){
            int num = i;
            int count = 0;
            while(num!=0){
                if(num%2==1){
                    count++;
                }
                num = num/2;
            }
            res[i] = count;
        }
        return res;
    }
}
