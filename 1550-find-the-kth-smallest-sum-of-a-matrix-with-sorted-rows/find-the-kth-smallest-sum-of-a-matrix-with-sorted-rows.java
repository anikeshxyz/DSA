class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        Set<String> seen = new HashSet<>();



        int sum = 0;
        int[] init = new int[m + 1]; 
        for (int i = 0; i < m; i++) {
            sum += mat[i][0];

            init[i + 1] = 0;  // column index in each row
        }
        init[0] = sum;


        pq.offer(init);
        seen.add(Arrays.toString(Arrays.copyOfRange(init, 1, init.length)));

        // Process until kth
        while (--k > 0) {
            int[] cur= pq.poll();
            int curSum =cur[0];

            int[] indices= Arrays.copyOfRange(cur, 1,cur.length);

            for (int i = 0;i< m;i++){
                if (indices[i] + 1 < n){
                    int[]next =Arrays.copyOf(cur,cur.length);
                    next[i + 1]++;// move to next column in row i

                    int add = mat[i][next[i + 1]] -mat[i][indices[i]];
                    next[0]=curSum + add;


                    String key = Arrays.toString(Arrays.copyOfRange(next,1,next.length));
                    if (seen.add(key)) {
                        pq.offer(next);
                    }
                }
            }
        }


        return pq.peek()[0];
    }
}
