class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int maxPair = 0;
        
        int i = 0, j = nums.length -1;
        while(i < j) {
            maxPair = Math.max(maxPair, nums[i] +nums[j]);
            i++;
            j--;
        }
        
        return maxPair;
    }
}