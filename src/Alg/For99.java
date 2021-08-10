package Alg;

/**
 * @author zhangsan
 * @date 2021-05-31 20:40
 */
public class For99 {
    public static void main(String[]args){
        for	(int m=1;m<=9;m++){
            for(int i=1;i<=m;i++){
                int a=i*m;
                System.out.print(i+"*"+m+"="+a+"\t");
            }
            System.out.println();
        }
    }
}
