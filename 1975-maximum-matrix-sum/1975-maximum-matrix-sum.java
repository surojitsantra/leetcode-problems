class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int mivValue = Integer.MAX_VALUE;
        int negativeCount = 0;
        
        for(int[] row: matrix) {
            for(int num :row) {
                sum += Math.abs(num);
                negativeCount += (num < 0)? 1 : 0;
                mivValue = Math.min(mivValue, Math.abs(num));
            }
        }
        
        if(mivValue == 0) {
            return sum;
        }
        if((negativeCount &1) == 0) {
            return sum;
        }
        return sum -mivValue -mivValue;
    }
}