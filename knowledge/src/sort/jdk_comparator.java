package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-06-08-10:22
 * @Description:
 */

class Student{
    // 姓名
    public String sName;
    // 性别
    public String sSex;
    // 年龄
    public int sAge;
    // 成绩
    public int sJava;

    // 需要有参的构造器
    public Student( String sName, String sSex, int sAge, int sJava) {
        this.sName = sName;
        this.sSex = sSex;
        this.sAge = sAge;
        this.sJava = sJava;
    }

}


public class jdk_comparator {
    public static void main(String[] args) {
        Integer[] arr = {4, 5, 3, 2, 6, 1, 7, 8, 9, 0};
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int x : arr
        ) {
            System.out.println(x);
        }
        Student[] studentArray = new Student[5];
        studentArray[0] = new Student("Jack", "男", 22, 89);
        studentArray[1] = new Student("Lucy", "女", 20, 94);
        studentArray[2] = new Student("Gon", "男", 22, 100);
        studentArray[3] = new Student("Rose", "女", 23, 96);
        studentArray[4] = new Student("Stark", "男", 22, 95);
        
        //
        Arrays.sort(studentArray, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.sAge-o2.sAge;
            }
        });
        
        printBoo(studentArray);
        
        //lambda表达式
        Arrays.sort(studentArray,(o1,o2)->{
            return o2.sAge- o1.sAge;
        });
        
        printBoo(studentArray);
    }
    
    public static void printBoo(Student[] studentArray){
        for (Student s1:studentArray
        ) {
            System.out.println(s1.sName);
        }
    }
        
       
    
}
