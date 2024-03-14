class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        int sum = 0;
        int ans = 0;
        
        for(int num :nums) {
            sum += num;
            if(sum == goal) {
                ans++;
            }
            
            if(sumCount.containsKey(sum -goal)) {
                ans += sumCount.get(sum -goal);
            }
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) +1);
        }
        
        return ans;
        
    }
}