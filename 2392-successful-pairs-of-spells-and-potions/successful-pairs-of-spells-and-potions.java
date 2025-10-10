class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int [] ans = new int [n];
        for(int i = 0 ;i <n;i++){
            long spell = spells[i];
            int left = 0, right = m -1,index = m;
            while(left <=right){
                int mid = left +(right - left)/2;
                long product = spell * (long) potions[mid];
                if(product >= success){
                    index = mid;
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            ans[i] = m-index;
        }
        return ans;
    }
}