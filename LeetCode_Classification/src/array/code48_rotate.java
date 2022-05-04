package array;

/**
 * @Author: yangbo
 * @Date: 2022-05-04-20:58
 * @Description:
 */
public class code48_rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for(int i=0;i<n;i++){
            //遍历右下角就行
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];   
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0;i<n;i++){
            for (int j = 0,k = n-1; j<k; j++,k--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
    }
}
