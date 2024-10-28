class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        Arrays.sort(nums);
        final int N = nums.length;
        
        for(int num :nums) numsSet.add(num);
        
        int maxStreak = 0;
        for(int i = 0; i < N; i++) {
            int currNum = nums[i];
            if(!numsSet.contains(currNum)) {
                continue;
            }
            
            int count = 1;
            numsSet.remove(currNum);
            while(numsSet.contains(currNum *currNum)) {
                currNum = currNum *currNum;
                numsSet.remove(currNum);
                count++;
            }
            
            maxStreak = Math.max(maxStreak, count);
        }
        
        return maxStreak == 1? -1 : maxStreak;
    }
}