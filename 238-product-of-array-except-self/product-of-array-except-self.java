class Solution {
    public int[] productExceptSelf(int[] nums) {
      int n = nums.length;
        int zeroCount = 0;
        int totalProduct = 1;

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                totalProduct *= num;
            }
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (zeroCount > 1) {
                result[i] = 0;
            } else if (zeroCount == 1) {
                result[i] = (nums[i] == 0) ? totalProduct : 0;
            } else {
                result[i] = totalProduct / nums[i];
            }
        }

        return result;
    }
}