class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer > freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
        PriorityQueue <int []> heap = new PriorityQueue<>((a,b) -> a[1] -b[1]);
    for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
        heap.offer(new int[]{entry.getKey(),entry.getValue()});

        if(heap.size()>k){
            heap.poll();
        }
    }
    int [] result = new int [k];
    for(int i =k-1;i>=0;i--){
        result[i]=heap.poll()[0];
    }
    return result;
    }

}