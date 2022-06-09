package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-06-07-23:09
 * @Description:
 */
public class code406_reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] person1, int[] person2) {
                if(person1[0]!=person2[0]){
                    //第一个元素不相等   按照第一个降序
                    return person2[0]-person1[0];
                }else {
                    //第一个元素相等  第二个升序
                    return person1[1]-person2[1];
                }
            }
        });
        
        //新建一个list  保存结果
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            if(list.size()>people[i][1]){
                //添加到
                list.add(people[i][1],people[i]);
            }else {
                //添加到后面
                list.add(list.size(),people[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
