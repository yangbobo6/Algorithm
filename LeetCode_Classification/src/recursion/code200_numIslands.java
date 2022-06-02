package recursion;

/**
 * @Author: yangbo
 * @Date: 2022-06-01-20:30
 * @Description:
 * 岛屿数量  dfs解题
 */
public class code200_numIslands {
    public int numIslands(char[][] grid) {
        //定义岛屿的数量
        int count = 0;
        //两层循环遍历所有的陆地
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //取出所有的陆地，深度遍历
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
                
            }
            
        }
        return count;

    }
    
    private void dfs(char[][] grid,int r,int c){
        //判断base case
        if(!isInArea(grid,r,c)){
            return;
        }

        //判断base case
//        if (r >= grid.length || c >= grid[0].length || r < 0 || c < 0) {
//            return;
//        }
        
        if(grid[r][c]!='1'){
            return;
        }
        //将格子标记为已遍历
        grid[r][c] = '2';
        
        //访问 上下左右四个相邻节点
        dfs(grid,r+1,c);
        dfs(grid,r,c+1);
        dfs(grid,r-1,c);
        dfs(grid,r,c-1);
        
    }
    
    
    //判断r,c是否在网格中
    private boolean isInArea(char[][] grid,int r,int c){
        return r>=0 && r<grid.length && c>=0 && c<grid[0].length;
    }
}
