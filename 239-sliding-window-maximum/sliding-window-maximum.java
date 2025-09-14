class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if( nums == null || k<- 0) return new int [0];
        int n= nums.length;
        if(k==1) return nums.clone();

        Deque<Integer> dq = new ArrayDeque<>();
        int [] result = new int [n- k+1];
        int ri = 0;

        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] <=nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if(!dq.isEmpty()  && dq.peekFirst()<=i-k){
                dq.pollFirst();

            }
            if(i>= k-1){
                result[ri++]= nums[dq.peekFirst()];
            }
        }
        return result;
    }
}