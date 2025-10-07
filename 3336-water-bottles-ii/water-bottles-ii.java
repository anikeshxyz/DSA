class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
     int consumed = numBottles;
     while(numBottles>=numExchange){
        numBottles -=numExchange -1;
        numExchange++;
        consumed++;
     }   
     return consumed;
    }
}