class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        
        // Convert 2D board to string
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }
        String start = sb.toString();

        // Neighbors map for index-based moves
        int[][] neighbors = {
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {1, 3, 5},
            {2, 4}
        };

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(target)) return steps;

                int zeroIndex = cur.indexOf('0');

                for (int next : neighbors[zeroIndex]) {
                    String swapped = swap(cur, zeroIndex, next);
                    if (!visited.contains(swapped)) {
                        queue.offer(swapped);
                        visited.add(swapped);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    // Helper function to swap characters in a string
    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
