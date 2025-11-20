class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new  ArrayList<>();
        for(int den = 2 ;den<=n;den ++){
            for(int num = 1 ;num<den ;num++){
                if(gcd(num,den)==1){
                    res.add(num+"/" +den);
                }
            }
        }
        return res;
    }
    private int gcd(int a , int b ){
        while(b !=0){
            int temp= a %b;
            a = b;
            b= temp;
        }
        return a;
    }
}