class Solution {
    public int maxSubArray(int[] nums) {
        int CS = 0;
        int  MS = Integer.MIN_VALUE;

        for(int i = 0;i<nums.length;i++){
            CS +=nums[i];
            MS=Math.max(CS,MS);

            if(CS<0){
                CS=0;
            }
        }
        return MS;

    }
}