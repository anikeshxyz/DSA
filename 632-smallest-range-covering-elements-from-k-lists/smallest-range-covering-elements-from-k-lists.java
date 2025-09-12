class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
      PriorityQueue<int []> pq= new PriorityQueue<>((a,b) -> a[0]-b[0]);
      int currM = Integer.MIN_VALUE;
      
        for(int i= 0; i < nums.size();i++){
        int val = nums.get(i).get(0);
        pq.offer(new int[]{val,i,0});

        currM =Math.max(currM,val);

      }
      int rangeS=0,rangeE=Integer.MAX_VALUE;
      while(pq.size() ==nums.size()){
        int []top = pq.poll();
        int minval =top[0],row = top[1] ,col =top[2];
        if(currM- minval < rangeE - rangeS){
             rangeS = minval;
                rangeE = currM;
        }
            if (col + 1 < nums.get(row).size()) {
                int nextval = nums.get(row).get(col + 1);
                pq.offer(new int[]{nextval, row, col + 1});
                currM = Math.max(currM, nextval);
        }else{
            break;
        }


      }
      return new int []{rangeS,rangeE};
      


    }
}