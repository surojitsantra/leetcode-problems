class Solution {

    public int maximumBeauty(int[] nums, int k) {
        final int  N = nums.length;
        
        Arrays.sort(nums);
        int right = 0;
        int maxBeauty = 0;
        
        for (int left = 0; left < N; left++) {

            while (right < N && nums[right] -nums[left] <= k *2) {
                right++;
            }
            
            maxBeauty = Math.max(maxBeauty, right -left);
        }
        return maxBeauty;
    }
}