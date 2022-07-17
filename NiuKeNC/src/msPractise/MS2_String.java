package msPractise;

/**
 * @Author: yangbo
 * @Date: 2022-07-15-21:57
 * @Description:
 */
public class MS2_String {

    public static void main(String[] args) {
        String s = "BAONXXOLL";
        int num = solution_BALLOON(s);
        System.out.println(num);
    }
    
    public static int solution_BALLOON(String S){
        int len = S.length();
        if(len<7){
            return 0;
        }
        
        int[] arr = new int[5];
        char[] chars = S.toCharArray();
        for (int i = 0; i < len; i++) {
            if(chars[i]=='B')
                arr[0]++;
            if(chars[i]=='A')
                arr[1]++;
            if(chars[i]=='L')
                arr[2]++;
            if(chars[i]=='O')
                arr[3]++;
            if(chars[i]=='N')
                arr[4]++;
        }
        
        int res = Integer.MAX_VALUE;
        res = Math.min(arr[0]/1,res);
        res = Math.min(arr[1]/1,res);
        res = Math.min(arr[2]/2,res);
        res = Math.min(arr[3]/2,res);
        res = Math.min(arr[4]/1,res);
        return res;
    }
}
