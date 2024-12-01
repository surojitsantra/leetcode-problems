class Solution {
    public int maxScore(int[] cardPoints, int k) {
        final int N = cardPoints.length;
        int maxPoint = 0;
        
        int start = N -k;
        int currSum = 0;
        for(int i = start; i < N; i++) currSum += cardPoints[i];
        
        for(int i = 0; i <= k; i++) {
            maxPoint = Math.max(maxPoint, currSum);
            currSum -= cardPoints[(start +i) %N];
            currSum += cardPoints[(start +i +k) %N];
        }
        
        return maxPoint;
    }
}