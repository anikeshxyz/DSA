class Solution {
    private static final int [][] DIRS= {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

         pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        while(!pq.isEmpty()){
            int [] cur = pq.poll();
            int time = cur[0];
            int x = cur[1];
            int y = cur[2];

            if(x == n -1 && y ==n-1) return time;
            for(int [] dir : DIRS){
                int nx=x+dir[0];
                int ny=y+dir[1];
                if (nx >= 0 && ny >= 0 && nx <n && ny< n && !visited[nx][ny]){
                visited[nx][ny] = true;
                pq.offer(new int[]{Math.max(time, grid[nx][ny]), nx,ny});
            }
        }
        
    }
    return -1;
}

}