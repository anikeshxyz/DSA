class Solution {
    public boolean find132pattern(int[] nums) {
         if (nums == null || nums.length < 3) return false;

        Deque<Integer> stack = new ArrayDeque<>(); 
        int third = Integer.MIN_VALUE;            
        for (int i = nums.length - 1; i >= 0; i--) {
            int x = nums[i];
            if (x < third) return true;
            while (!stack.isEmpty() && x > stack.peek()) {
                third = stack.pop(); 
            }
            stack.push(x);
        }
        return false;
    }
}