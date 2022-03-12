package recursion;

/**
 * @Author: yangbo
 * @Date: 2022-03-12-19:44
 * @Description:  汉诺塔  典型的递归问题
 */
public class Hanoi {
    public static void hanoi(int n){
        if(n>0){
            func(n,"左","右","中");
        }
    }

    public static void func(int n,String from,String to,String other){
        if(n==1){
            System.out.println("Move 1 from "+from+"to"+to);
        }else {
            func(n-1,from,other,to);
            System.out.println("Move "+n+"from"+from+"to"+to);
            func(n-1,other,to,from);
        }
    }

    public static void main(String args[]){
        int n = 3;
        hanoi(n);
    }
}
