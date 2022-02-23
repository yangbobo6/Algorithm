package TreeNode_Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-02-18-15:18
 * @Description:
 */
public class test {

    // 将一个数组复制到  集合对象里面
    static void fromArrayToCollection(Object[] a, Collection<Object> c){
        for(Object o:a){
            c.add(o);
        }
    }
    //泛型解决
    static <T> void fromArrayToCollection1(T[] a,Collection<T> c){
        for (T o: a
             ) {
            c.add(o);
        }
    }


/*    public static void main(String[] args) {
        String[] strArr = {"yangbo","a"};
        List<String> strList = new ArrayList<>();
        //fromArrayToCollection(strArr,strList);
        fromArrayToCollection1(strArr,strList);
    }*/
    public static <T> void copy(List<T> dest,List<? extends T> src){}


    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        //添加会因为类型出错
        //list.add("a");

        //通过反射来添加
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        add.invoke(list,"zhu");
        System.out.println(list);

        Class<? extends List> clazz1 = List.class;
        Method add1 = clazz1.getDeclaredMethod("add", Object.class);

    }


}
