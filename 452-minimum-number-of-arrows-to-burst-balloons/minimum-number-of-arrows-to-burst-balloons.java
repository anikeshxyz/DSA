class Solution {
    public int findMinArrowShots(int[][] point) {
        if(point ==null || point.length ==0)return 0;
        Arrays.sort(point, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows =1;
        long arrowpos = point [0] [1];

        for(int i =1;i<point.length;i++){
            if(point[i][0] >arrowpos){
                arrows++;
                arrowpos = point[i][1];
            }
        }
        return arrows;
    }
}