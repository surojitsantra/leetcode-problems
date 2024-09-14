class Solution {
    public int longestSubarray(int[] nums) {
        int currStreak = 0;
        int maxStreak = 0;
        int maxNo = 0;
        
        for(int num :nums) {
            if(num > maxNo) {
                maxNo = num;
                currStreak = maxStreak = 0;
            }
            
            if(num == maxNo) {
                currStreak++;
            } else {
                currStreak = 0;
            }
            
            maxStreak = Math.max(maxStreak, currStreak);
        }
        
        return maxStreak;
    }
}