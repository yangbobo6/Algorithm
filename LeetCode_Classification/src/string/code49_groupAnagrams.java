package string;

import java.util.*;

/**
 * @Author: yangbo
 * @Date: 2022-03-02-20:33
 * @Description:
 */
public class code49_groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String ,List<String >> map = new HashMap<>();

        for (String str:strs
             ) {
            //将字符串改为字符数组  方便排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            //如果map没有key  则创建新的list
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            map.put(key,list);

        }
        //获取map所有的value值
        return new ArrayList<List<String>>(map.values());
    }
}
