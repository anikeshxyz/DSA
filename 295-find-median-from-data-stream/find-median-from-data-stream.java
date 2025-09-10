class MedianFinder {
private PriorityQueue<Integer> lower;
private PriorityQueue<Integer> higher;

    public MedianFinder() {
        lower = new PriorityQueue<>(Collections.reverseOrder());
        higher = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
       if (lower.isEmpty() || num <= lower.peek()){
            lower.offer(num);
        } else {
            higher.offer(num);
        }
        if (lower.size() < higher.size()){
            lower.offer(higher.poll());
        } else if (lower.size() - higher.size() > 1){
            higher.offer(lower.poll());
        }
    }
    
    public double findMedian(){
        int total = lower.size() + higher.size();
        if(total ==0)return 0.0;
        if((total &1) ==1){
            return lower.peek();

        }else{
            return (lower.peek()+ higher.peek())/2.0;
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */