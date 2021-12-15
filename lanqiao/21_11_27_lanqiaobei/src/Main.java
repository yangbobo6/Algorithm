import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        m = m-1;
        boolean flag = false;
        if(m>50&&m<20000){
            for (int i = 0; i < 10; i++) {
                while(flag==false){
                    int j =2;
                    for ( j = 2; j < m/2; j++) {
                        if(m%j==0){
                            break;
                        }
                    }
                    m--;
                    if(j == m/2){
                        flag = true;
                    }
                }
                System.out.printf("%6d",m+1);
                flag = false;
            }
        }
    }
}
