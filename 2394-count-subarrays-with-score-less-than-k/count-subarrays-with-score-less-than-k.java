class Solution {
    public long countSubarrays(int[] nums, long k) {
      long sum = 0 ;
      long count =0;
      int l  =0;
      for(int r = 0;r<nums.length;r++){
        sum += nums[r];
        while (sum*(r-l+1)>=k){
            sum -= nums[l];
            l++;
        }
        count +=(r-l+ 1);



      }
      return count;
    }
}