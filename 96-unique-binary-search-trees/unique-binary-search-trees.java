class Solution {
    public int numTrees(int n) {
        long[] G =new long[n+ 1];
        G[0]= 1;
        G[1]=1;
        for (int nodes = 2; nodes <= n; nodes++){
            long total = 0;
            for (int root = 1; root <= nodes; root++){
             total += G[root - 1] * G[nodes - root];
            }
            G[nodes] = total;
        }
        return (int) G[n];
    }
}