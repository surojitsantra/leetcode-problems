class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length -1;
        int minEle = Integer.MAX_VALUE;
        
        while(left <= right) {
            int mid = (left +((right -left) /2));
            minEle = Math.min(minEle, nums[mid]);
            
            if(nums[mid] < nums[right]) {
                right = mid -1;
            } else {
                left = mid +1;
            }
            
        }
        
        return minEle;
    }
}