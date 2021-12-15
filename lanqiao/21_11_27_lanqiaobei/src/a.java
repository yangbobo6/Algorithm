import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class a {
    public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int N = s.nextInt();
            int a[] = new int[N];
            if (N <= 20000 && N > 0) {
                for (int i = 0; i < N; i++) {
                    int value = s.nextInt();
                    if (value <= 1000000 && value > 0) {
                        a[i] = value;
                    }

                }
            }
            Arrays.sort(a);
            int flag = 0;
            int count = 1;
            while (a[flag] == a[flag + 1]) {
                count++;
                flag++;
            }
            int flag1 = N - 1;
            int count1 = 1;
            while (a[flag1] == a[flag1 - 1]) {
                count1++;
                flag1--;
            }

            System.out.println(a[0] + " " + count);
            System.out.print(a[N - 1] + " " + count1);
        }

}
