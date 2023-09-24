class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] prevRow = new double[] {poured};
        
        for(int row = 1; row <= query_row; row++) {
            double[] currRow = new double[row +1];
            for(int i = 0; i < row; i++) {
                double extra =  prevRow[i] -1;
                if(extra <= 0) continue;
                currRow[i] += extra /2;
                currRow[i +1] += extra /2;
            }
            prevRow = currRow;
        }
        return Math.min(1, prevRow[query_glass]);
    }
}