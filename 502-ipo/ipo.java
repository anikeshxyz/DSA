class Solution {
    public int findMaximizedCapital(int k, int w, int[] profit, int[] capital) {
        int n = profit.length;
        int [][] project = new int [n][2];

        for(int i =0;i<n;i++){
            project[i][0] = capital[i];

            project[i][1] = profit[i];
        }
            Arrays.sort(project,(a,b) ->a[0] - b[0]);

            PriorityQueue<Integer> maxHeap = new PriorityQueue <>((a,b) -> b-a);
            int index= 0;
            int currentCapital = w;
            for(int i = 0;i<k;i++){
                while(index <n && project[index][0]<= currentCapital){
                    maxHeap.offer(project[index][1]);
                    index++;
                }
                if(maxHeap.isEmpty()) break;
                currentCapital +=maxHeap.poll();

            } 
            return currentCapital;

        }
    }
