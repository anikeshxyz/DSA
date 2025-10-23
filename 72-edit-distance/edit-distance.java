class Solution {
    public int minDistance(String w1, String w2) {
        final int m = w1.length();
        final int n = w2.length();
        int[][] costdp=new int [m+1][n+1];

        for(int i = 1;i<=m;i++)costdp[i][0]=i;
        for(int j =1;j<=n;j++)costdp[0][j]=j;

        for(int i = 1;i<=m;++i)
        for(int j = 1 ;j<=n;++j)
        if(w1.charAt(i-1)==w2.charAt(j-1))
            costdp[i][j]=costdp[i-1][j-1];
        else{
            int topLeft =costdp[i-1][j-1];
            int top = costdp[i-1][j];
            int left = costdp[i][j-1];
            costdp[i][j]=Math.min(topLeft,Math.min(top,left))+1;    
                }
                return costdp[m][n];
    }
        
    }
