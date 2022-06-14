package bucket;

/**
 * @Author: yangbo
 * @Date: 2022-06-13-21:08
 * @Description:
 */
public class code621_leastInterval {
    public int leastInterval(char[] tasks, int n) {
        int[] temp = new int[26];
        int countMaxTask = 0;
        int maxTask = 0;
        
        //求出现最多的 任务
        for (char c:tasks
             ) {
            temp[c-'A']++;
            maxTask = Math.max(temp[c-'A'],maxTask);
        }
        //任务出现的次数
        for (int i = 0;i<26;i++){
            if(temp[i]==maxTask){
                countMaxTask++;
            }
        }
        return Math.max(tasks.length,(maxTask-1)*(n+1)+countMaxTask);
    }

    public static void main(String[] args) {
        code621_leastInterval c = new code621_leastInterval();
        char[] chars = new char[]{'A','A','A','B','B','B','A','A','A','B','B','B','C','C','D','D','D','D'};
        int n = 2;
        int i = c.leastInterval(chars, n);
        System.out.println(i);
    }
}