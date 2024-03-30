class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindowAtMost(nums, k) - slidingWindowAtMost(nums, k -1); 
    }
    
    private int slidingWindowAtMost(int[] nums, int k) {
        final int N = nums.length;
        Map<Integer, Integer> numsFreq = new HashMap<>();
        
        int i = 0, j = 0;
        int count = 0;
        while(j < N) {
            numsFreq.put(nums[j], numsFreq.getOrDefault(nums[j], 0) +1);
            
            while(numsFreq.size() > k) {
                numsFreq.put(nums[i], numsFreq.getOrDefault(nums[i], 0) -1);
                if(numsFreq.get(nums[i]) == 0) {
                    numsFreq.remove(nums[i]);
                }
                i++;
            }
            
            count += (j -i +1);
            j++;
            
        }
        
        return count;
    }
}