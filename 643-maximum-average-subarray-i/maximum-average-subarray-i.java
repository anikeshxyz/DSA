class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int ws = 0;


        for(int i = 0;i<k;i++){
            ws += nums[i];
        }

        int MS = ws;
 
        for(int i = k;i<n;i++){
            ws +=nums[i];
            ws -=nums[i-k];

            MS = Math.max(MS, ws);
        }
            return (double)MS/k;


    }
}