class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

         
         int[] inDegree = new int[numCourses];
        for(int [] pre:prerequisites){
            adj.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;

        }
        Queue<Integer> queue= new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(inDegree[i]==0) {
                queue.offer(i);
            }

    }

        int[] order = new int[numCourses];
        int count = 0 ;

    while(!queue.isEmpty()){
        int curr = queue.poll();
       order [count++] =curr;

        for(int next :adj.get(curr)){
            inDegree[next] --;
            if(inDegree[next]==0){

             queue.offer(next);

        
        }
    }
    }

    if (count == numCourses) return order;
        return new int[0];}
}