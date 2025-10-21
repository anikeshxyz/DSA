class Solution {
    public int mincostTickets(int[] days, int[] cost) {
     int n = days.length;
     int [] dp = new int [n+1];
     dp[n] = 0;

        for (int i = n - 1; i >= 0; i--){
        int cost1= cost[0]+dp[nextIndex(days,i, days[i] + 1)];
        int cost7= cost[1]+dp[nextIndex(days,i, days[i] + 7)];
        int cost30= cost[2]+dp[nextIndex(days,i, days[i] + 30)];
        dp[i] = Math.min(cost1,Math.min(cost7,cost30));
     }
     return dp[0];

    }
    private int nextIndex(int[] days,int i,int limit){
        int j = i;
        while(j < days.length && days[j] < limit) j++;
        return j;
    }
}