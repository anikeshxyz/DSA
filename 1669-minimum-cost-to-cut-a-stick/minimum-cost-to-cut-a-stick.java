class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int [] pos = new int [m+2];
        pos[0] = 0;
        pos [m+1]= n;
        for (int i= 0;i< m;i++) pos[i+1]=cuts[i];
        Arrays.sort(pos);
        int M = m+2;
        int [][] dp = new int [M][M];
        for(int len = 2;len<M;len++){
            for(int i = 0;i+len<M;i++){
                int j = i+len;
                int best = Integer.MAX_VALUE;
                for(int k = i+1;k<j;k++){
                    int cost = pos[j]- pos[i]+ dp[i][k] + dp[k][j];
                    if(cost < best )best =cost;

                }
                dp[i][j]= (best== Integer.MAX_VALUE) ? 0 :best;

            }
        }

        return dp[0][M-1];
    }
}