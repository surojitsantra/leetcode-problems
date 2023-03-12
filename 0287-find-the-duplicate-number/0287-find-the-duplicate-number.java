class Solution {
    public int findDuplicate(int[] nums) {
        //Using Bin search
        int low = 1, high = nums.length -1;
        
        int ans = 0;
        while(low <= high) {
            int mid = low +(high -low)/2;
            int count = 0;
            for(int num :nums) if(num <= mid) count++;
            
            if(count > mid) {
                ans = mid;
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return ans;
    }
}