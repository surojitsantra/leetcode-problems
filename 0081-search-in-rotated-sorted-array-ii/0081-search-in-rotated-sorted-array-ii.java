class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length -1;
        
        while(low <= high) {
            int mid = low +(high -low) /2;
            if(nums[mid] == target) return true;
            
            if((nums[low] == nums[mid]) && (nums[high] == nums[mid])) {
                low++;
                high--;
            }
            else if(nums[low] <= nums[mid]) { //check left is sorted
                if(nums[low] <= target && target < nums[mid]) high = mid -1;
                else low = mid +1;
            } else { //right part sorted
                if(nums[mid] < target && target <= nums[high]) low = mid +1;
                else high = mid -1;
            }
        }
        return false;
    }
}