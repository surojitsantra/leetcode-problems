class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> (a[1] == b[1])? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        
        int curPointArrow = points[0][1];
        int noOfArrow = 1;
        
        for(int i = 1; i < points.length; i++) {
            int[] point = points[i];
            
            if(point[0] <= curPointArrow && curPointArrow <= point[1]) {
                continue;
            } 
            
            curPointArrow = point[1];
            noOfArrow++;
        }
        
        return noOfArrow;
    }
}