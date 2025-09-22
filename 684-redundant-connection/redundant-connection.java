
class Solution {
    public int[] findRedundantConnection(int[][] edges){
        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            int u = edge[0], v = edge[1];
            
            // Check if u and v are already connected using BFS
            if (isConnected(graph, u, v, n)) {
                return edge; // This edge creates a cycle
            }  
            // Otherwise, add edge to graph
            graph.get(u).add(v);

            graph.get(v).add(u);
        }

        return new int[1];
    }
    
    private boolean isConnected(List<List<Integer>> graph, int src, int target, int n){
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        visited[src]= true;
        while (!queue.isEmpty()){
            int node =queue.poll();
            if (node ==target) {
                return true; // Found path → already connected
            }
            for (int neighbor :graph.get(node)){
                if (!visited[neighbor]){
                    visited[neighbor] =true;
                    queue.offer(neighbor);
                }
            }
        }
        
        return false;
    }
}
