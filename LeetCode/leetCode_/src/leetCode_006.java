import java.util.ArrayList;
import java.util.List;

//z子变形
public class leetCode_006 {
    public String convert(String s, int numRows) {
        if(numRows<2){
            return s;
        }
        //创建一个集合保存每一行的数据
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        // 创建 和行数相同的数据
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        //反转的下标和反转的内容
        int i = 0 ,flag = -1;
        for (char c:s.toCharArray()
             ) {
            rows.get(i).append(c);
            if(i==0||i==numRows-1) {
                flag = -flag;
            }
            i+=flag;

        }
        //string组合
        StringBuilder res = new StringBuilder();
        //遍历 放入res
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
