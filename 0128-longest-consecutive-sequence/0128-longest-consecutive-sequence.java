class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for(int num :nums) numsSet.add(num);
        
        int maxStreak = 0;
        
        for(int num :nums) {
            int prevNo = num -1;
            int currentStreak = 0;
            if(!numsSet.contains(prevNo)) {
                while(numsSet.contains(num++)) currentStreak++;
            }
            maxStreak = Math.max(maxStreak, currentStreak);
        }
        
        return maxStreak;
    }
}