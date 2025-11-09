class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
          Queue<Integer> q = new LinkedList<>();
        for (int s : students) {
         q.offer(s);
        }
        int index = 0; 
        int rotations = 0;
        while (!q.isEmpty()) {
            if (q.peek() == sandwiches[index]) {
            q.poll();
             index++;
            rotations = 0;  
            } else {
                 q.offer(q.poll());
             rotations++;
            }
            if (rotations == q.size()) {
            break;
         }
        }
        return q.size();
    }
}