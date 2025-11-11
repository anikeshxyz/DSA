class Solution {
    public int minRefuelStops(int target, int startFuel, int[][]    stations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int stops = 0;
        int currentFuel = startFuel;
        int i = 0;
        int n = stations.length;
        while (currentFuel < target) {
            while (i < n && stations[i][0] <= currentFuel) {
             maxHeap.offer(stations[i][1]);
             i++;
            }
               if (maxHeap.isEmpty()) {
                return -1;
            }
                currentFuel += maxHeap.poll();
            stops++;
        }
        return stops;
    }
}