package dp;

/**
 * @Author: yangbo
 * @Date: 2022-05-24-23:02
 * @Description:   dp
 */
public class code64_minPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        
        sum[0][0] = grid[0][0];
        for (int i = 1;i<n;i++){
            sum[0][i] = sum[0][i-1]+grid[0][i];
        }
        for (int i = 1;i<m;i++){
            sum[i][0] =sum[i-1][0]+grid[i][0];
        }
        for (int i = 1;i<m;i++){
            for (int j = 1; j < n; j++) {
                sum[i][j] = Math.min(sum[i-1][j],sum[i][j-1])+grid[i][j];
            }
        }
        return sum[m-1][n-1];
    }
}
