class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int consecutiveOdds = 0;
        
        for(int num :arr) {
            if((num &1) == 1) {
                consecutiveOdds++;
            } else {
                consecutiveOdds = 0;
            }
            if (consecutiveOdds == 3) {
                return true;
            }
        }
        return false;
    }
}