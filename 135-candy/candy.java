// this appproach use L_R and R-L approach  first find l-r candies and r-l candies  then choose the max candy from that 

//Approac = 1

// class Solution {
//     public int candy(int[] ratings) {
//         int n = ratings.length;
//         int [] candy= new int [n];
//         Arrays.fill(candy ,1);
//         for(int i = 1;i<n;i++){
//             if(ratings[i]>ratings[i-1]){
//                 candy[i] = candy[i-1] +1;
//             }
//         }
//         for(int i = n-2;i>=0;i--){
//             if(ratings[i]>ratings[i+1]){
//                 candy[i] =Math.max(candy[i],candy[i+1]+1);
//             }
//         }
//         int total =0;
//         for(int c:candy)total += c;
//         return total;

//     }

// }


//Approac = 2

// this approach use Left → Right and Right → Left passes and choose the max 

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // Left- Right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        // Right- Left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.max(left[i], right[i]);
        }

        return total;
    }
}