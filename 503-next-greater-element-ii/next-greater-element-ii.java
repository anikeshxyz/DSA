class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Default is -1
        Stack<Integer> stack = new Stack<>(); 
        // Traverse the array twice 
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            
            // current number is greater than stack top
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            // Only push index from the first round
            if (i < n) {
                stack.push(i);
            }
        }
        return result;
    }
}