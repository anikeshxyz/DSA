class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int p : piles){
            pq.offer(p);

        }
        while(k -->0){
            int largest = pq.poll();
            int remain = largest - largest/2;
            pq.offer(remain);

        }
        int total = 0;
        for (int val : pq){
            total += val;
        }

        return total;
    }
}