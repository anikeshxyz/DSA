class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         List<int[]> result = new ArrayList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        boolean inserted = false;
        for (int[] interval : intervals) {
            if (interval[1] < newStart) {
                result.add(interval);
            }
            else if (interval[0] > newEnd) {
                if (!inserted) {
                    result.add(new int[]{newStart, newEnd});
                    inserted = true;
                }
                result.add(interval);
            }
            else {
                newStart = Math.min(newStart, interval[0]);
                newEnd = Math.max(newEnd, interval[1]);
            }
        }
        if (!inserted) {
            result.add(new int[]{newStart, newEnd});
        }
        return result.toArray(new int[result.size()][]);
    }
}
