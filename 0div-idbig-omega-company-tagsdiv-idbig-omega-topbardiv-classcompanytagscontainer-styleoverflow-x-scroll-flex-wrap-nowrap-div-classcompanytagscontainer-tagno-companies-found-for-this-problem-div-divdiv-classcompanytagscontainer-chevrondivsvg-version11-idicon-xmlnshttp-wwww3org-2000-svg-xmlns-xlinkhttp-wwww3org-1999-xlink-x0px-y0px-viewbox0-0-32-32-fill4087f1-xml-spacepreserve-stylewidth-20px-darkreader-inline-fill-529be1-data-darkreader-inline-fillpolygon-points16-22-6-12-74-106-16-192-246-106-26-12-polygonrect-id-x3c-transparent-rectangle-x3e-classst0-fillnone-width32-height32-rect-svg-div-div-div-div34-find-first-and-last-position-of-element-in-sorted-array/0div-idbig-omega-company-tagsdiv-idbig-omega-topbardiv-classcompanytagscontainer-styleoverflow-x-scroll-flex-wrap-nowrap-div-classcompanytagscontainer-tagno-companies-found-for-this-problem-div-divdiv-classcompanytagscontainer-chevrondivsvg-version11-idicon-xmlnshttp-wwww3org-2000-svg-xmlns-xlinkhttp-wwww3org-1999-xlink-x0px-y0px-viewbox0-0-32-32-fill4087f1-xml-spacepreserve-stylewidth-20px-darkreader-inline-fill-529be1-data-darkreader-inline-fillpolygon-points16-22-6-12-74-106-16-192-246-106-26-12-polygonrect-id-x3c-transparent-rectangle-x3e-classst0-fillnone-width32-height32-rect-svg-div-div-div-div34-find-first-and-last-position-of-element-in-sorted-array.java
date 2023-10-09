class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurrence(nums, target);
        if(first == -1) return new int[] {-1, -1};
        
        int last = lastOccurrence(nums, target);
        
        return new int[] {first, last};
    }
    
    private int firstOccurrence(int[] nums, int target) {
        int idx = -1;
        
        int left = 0, right = nums.length -1;
        while(left <= right) {
            int mid = left +(right -left)/2;
            if(nums[mid] == target) {
                idx = mid;
                right = mid -1;
            } else if(nums[mid] < target) {
                left = mid +1;
            } else {
                right = mid -1;
            }
        }
        
        return idx;
    }
    
    private int lastOccurrence(int[] nums, int target) {
        int idx = -1;
        
        int left = 0, right = nums.length -1;
        while(left <= right) {
            int mid = left +(right -left)/2;
            if(nums[mid] == target) {
                idx = mid;
                left = mid +1;
            } else if(nums[mid] < target) {
                left = mid +1;
            } else {
                right = mid -1;
            }
        }
        
        return idx;
    }
    
}