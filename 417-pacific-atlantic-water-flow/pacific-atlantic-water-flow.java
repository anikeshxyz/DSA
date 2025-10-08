import java.util.*;

class Solution {
    private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) return result;
        int m = heights.length, n = heights[0].length;
          boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific: top and left borders
        for(int i = 0; i < m; i++) dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
        for (int j= 0; j < n; j++) dfs(heights, pacific, 0, j, Integer.MIN_VALUE);

        // Atlantic: bottom and right borders
        for (int i= 0; i < m; i++) dfs(heights, atlantic, i,n - 1, Integer.MIN_VALUE);
        for (int j= 0; j < n; j++) dfs(heights,atlantic, m - 1, j, Integer.MIN_VALUE);

        // Collect cells reachable by both oceans
        for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }
    private void dfs(int[][] heights, boolean[][] ocean, int i, int j, int prevHeight) {
        int m = heights.length, n = heights[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (ocean[i][j]) return;
        if (heights[i][j] < prevHeight) return;

        ocean[i][j] = true;
        for (int[] d : dirs) {
            dfs(heights, ocean, i + d[0], j + d[1], heights[i][j]);
        }
    }
}
