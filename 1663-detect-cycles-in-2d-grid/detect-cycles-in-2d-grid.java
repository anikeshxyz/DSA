class Solution {

    int rows, cols;
    char[][] grid;
    int[][] depth;
    int[][] dirs ={{-1,0},{0,1},{1,0},{0,-1}};
    public boolean containsCycle(char[][] grid){
        if (grid== null || grid.length == 0)return false;
        this.grid =grid;
        rows = grid.length;
        cols =grid[0].length;
        depth= new int[rows][cols]; 
        
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (depth[r][c] == 0){
                    if (dfs(r, c, 1, grid[r][c])) return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int r, int c, int d, char targetChar){
        depth[r][c] =d;
        for (int[]dir :dirs){
            int nr =r +dir[0];
            int nc = c+ dir[1];
            if (nr < 0||nr >= rows||nc <0 || nc >=cols) continue;
            if (grid[nr][nc] != targetChar)continue;
            
            if (depth[nr][nc]== 0) {
                if (dfs(nr,nc,d +1,targetChar))return true;
            } else {
                if (d -depth[nr][nc] +1 >=4) return true;
            }
        }
        
        return false;
    }
}
