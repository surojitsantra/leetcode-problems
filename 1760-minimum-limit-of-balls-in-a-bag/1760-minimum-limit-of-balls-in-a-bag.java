class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        // Bin search
        int minPenalty = 1, maxPenalty = Integer.MIN_VALUE;
        for(int ball :nums) maxPenalty = Math.max(maxPenalty, ball);
        
        int minPenaltyPossible = maxPenalty;
        
        while(minPenalty <= maxPenalty) {
            int midPenalty = minPenalty +(maxPenalty -minPenalty)/2;
            if(isPossiblePenalty(nums, maxOperations, midPenalty)) {
                minPenaltyPossible = midPenalty;
                maxPenalty = midPenalty -1;
            } else {
                minPenalty = midPenalty +1;
            }
        }
        return minPenaltyPossible;
    }
    
    private boolean isPossiblePenalty(int[] nums, int maxOperations, int maxPenaltyThreshold) {
        int operationsDone = 0;
        for(int ball :nums) {
            if(ball %maxPenaltyThreshold == 0) {
                operationsDone += (ball /maxPenaltyThreshold) -1;
            } else {
                operationsDone += (ball /maxPenaltyThreshold);
            }
            if(operationsDone > maxOperations) return false;
        }
        return true;
    }
}