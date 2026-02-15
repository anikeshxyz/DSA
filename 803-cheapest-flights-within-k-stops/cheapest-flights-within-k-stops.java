class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int INF = Integer.MAX_VALUE / 2;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for (int i = 0; i <= K; i++) {
            int[] temp = dist.clone();
            for (int[] f : flights) {
                int u = f[0];
                int v = f[1];
                int w = f[2];
                if (dist[u] != INF && dist[u] + w < temp[v]) {
                    temp[v] = dist[u] + w;
                }
            }
            dist = temp;
        }
        return dist[dst] == INF ? -1 : dist[dst];
    }
}
