package array;

/**
 * @Author: yangbo
 * @Date: 2022-04-24-21:34
 * @Description: 数独---
 */
public class code36_isValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.'){
                    continue;
                }
                int value = board[i][j]-'1';
                //判断行
                if(row[i][value]==1){
                    return false;
                }
                //判断列
                if(col[j][value]==1){
                    return false;
                }
                //判断box内
                if(box[j/3+(i/3)*3][value]==1){
                    return false;
                }
                row[i][value] =1;
                col[j][value]=1;
                box[j/3+(i/3*3)][value]=1;
                
            }
        }
        return true;
    }
}
