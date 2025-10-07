class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
//         int consumed = numBottles;
//         int empty = numBottles;
//         while(empty >= numExchange){
//             int extraF = empty/numExchange;
//             int remain = empty % numExchange;
//             consumed += extraF;
//             empty= remain + extraF;
//         }
//         return consumed;
//     }
// }
return numBottles + (numBottles-1)/ (numExchange-1);

    }
}