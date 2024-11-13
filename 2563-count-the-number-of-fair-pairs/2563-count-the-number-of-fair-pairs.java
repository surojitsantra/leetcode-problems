class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long pairCount = 0;
        final int N = nums.length;
        
        for(int i = 0; i < N; i++) {
            int left = lowerBound(nums, i +1, N -1, lower -nums[i]);
            int right = lowerBound(nums, i +1, N -1, upper -nums[i] +1);
            pairCount += (right -left);
        }
        
        return pairCount;
    }
    
    private int lowerBound(int[] nums, int low, int high, int num) {
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] >= num) {
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return low;
    }
    
}