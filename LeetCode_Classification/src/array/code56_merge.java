package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-05-04-22:21
 * @Description:  合并区间方法
 * 1.先排序  按照第一个数组中第一个的大小去排序
 * 2.判断如果区间重复，就合并    不重复，就全部加载进去
 */
public class code56_merge {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        
        //将二维数组按照第一个的大小进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //list里面的是二维数组
        List<int[]> merge = new ArrayList<>();
        
        //  [[0,2],[1,5],[6,8],[10,11]]
        for(int i = 0;i<n;i++){
            int left = intervals[i][0];
            int right = intervals[i][1];

            //直接 add 的情况：当为第一行或者相邻两行无重叠时
            //解释：两行无重叠,即对应在 merge 中上一行的第 1 列小于本行第 0 列 
            if(merge.size()==0||merge.get(merge.size()-1)[1]<left){
                merge.add(new int[]{left,right});
            }
            //合并的情况：当有重叠时,将 merge 中上一行的右边界更新
            else {
                merge.get(merge.size()-1)[1] = Math.max(merge.get(merge.size()-1)[1],right);
            }
            
        }
        //将 list<int[]> 转化为 int[][]
        return merge.toArray(new int[merge.size()][]);
    }
}
