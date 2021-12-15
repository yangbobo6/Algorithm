import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();

        if(m<=1000){
            int a[] = new int[m];
            for (int i = 0; i < m; i++) {
                int b=s.nextInt();
                if(b>=1&&b<=100){
                    a[i] = b;
                }
            }
        }
    }
}
