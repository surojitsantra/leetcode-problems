class Solution {
    public int arrangeCoins(int n) {
        //Bin search
        int minRow = 1, maxRow = n;
        
        int maxStairsPossible = minRow;
        while(minRow <= maxRow) {
            int midRow = minRow +(maxRow -minRow)/2;
            if(isPossibleStairs(n, midRow)) {
                maxStairsPossible = midRow;
                minRow = midRow +1;
            }else {
                maxRow = midRow -1;
            }
        }
        return maxStairsPossible;
    }
    
    private boolean isPossibleStairs(int coins, int stairs) {
        long minCoinReq = (((long)stairs *(stairs +1)) /2);
        return (minCoinReq <= coins);
    }
}