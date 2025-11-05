class Solution {
    public int[][] dp;
    public int superEggDrop(int k, int n) {
        dp = new int[k +1][n+ 1];
        for (int[]row :dp) {
          Arrays.fill(row, -1);
        }
        return solve(k, n);
    }
    private int solve(int eggs,int floors) {
       
        if(floors ==0||floors == 1) return floors;
        if(eggs ==1) return floors;
        if(dp[eggs][floors] != -1) return dp[eggs][floors];
        int low = 1, high = floors;
        int minAttempts = Integer.MAX_VALUE;
        // BS
        while (low<= high){
            int mid = (low+high) / 2;
            int breakCase =solve(eggs- 1,mid-1); // breaks
            int noBreakCase= solve(eggs,floors-mid); 
            int worst = 1 + Math.max(breakCase,noBreakCase);
            // BS
            if (breakCase > noBreakCase) {
                high =mid - 1;
            } else {
                low =mid + 1;
            }
            minAttempts = Math.min(minAttempts, worst);
        }
        dp[eggs][floors] = minAttempts;
        return minAttempts;
    }
}
