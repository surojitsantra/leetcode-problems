class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int strak = 0, maxStreak = 0;
        
        for(int num :nums) {
            if(num == 1) {
                strak++;
            } else {
                strak = 0;
            }
            
            maxStreak = Math.max(maxStreak, strak);
            
        }
        
        return maxStreak;
    }
}