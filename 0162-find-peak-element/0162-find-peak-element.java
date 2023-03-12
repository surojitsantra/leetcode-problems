class Solution {
    public int findPeakElement(int[] nums) {
        //Bin search
        int low = 0, high = nums.length -1;
        
        int ans = 0;
        while(low < high) {
            int mid = low +(high -low)/2;
            
            if(nums[mid] < nums[mid +1]) {
                low = mid +1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
}