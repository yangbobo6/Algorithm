package Alg;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangsan
 * @date 2021-05-31 21:24
 */
public class ListUnion {

    public static List<Integer> union(List<Integer> a , List<Integer> b){
        for (Integer integer : b) {
            if (!a.contains(integer)) {
                a.add(integer);
            }
        }
        //采用逐次比较   时间复杂度为o(mn)  空间复杂度为  m n中最大的
        return a;
    }

    public static void main(String[] args) {
        List<Integer> a=new ArrayList<>();
        List<Integer> b=new ArrayList<>();
        a.add(2);
        a.add(1);
        a.add(3);
        b.add(2);
        b.add(3);
        b.add(4);
        List<Integer> union = union(a, b);
        for (Integer integer : union) {
            System.out.println(integer);
        }
    }
}
