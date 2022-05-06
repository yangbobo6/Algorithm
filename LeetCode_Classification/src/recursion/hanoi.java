package recursion;

import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-05-05-15:44
 * @Description:
 */
public class hanoi {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        if(n>0){
            dfs(n,A,B,C);
        }
    }

    public void dfs(int n,List<Integer> A, List<Integer> B, List<Integer> C){
        if(n==1){
            C.add(0,A.remove(0));
            return;
        }else{
            dfs(n-1,A,C,B);
            C.add(0,A.remove(0));
            dfs(n-1,B,A,C);
        }
    }
}
