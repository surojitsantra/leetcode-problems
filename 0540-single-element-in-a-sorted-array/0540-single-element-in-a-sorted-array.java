class Solution {
    public int singleNonDuplicate(int[] nums) {
        final int N = nums.length;
        int low = 0, high = N -1;
        
        if(N == 1) return nums[0];
        
        while(low <= high) {
            int mid = (low +(high -low) /2);
            
            boolean evenPos = (mid %2 == 0);
            
            int num = nums[mid];
            int prev = (mid -1 >= 0)? nums[mid -1] : Integer.MIN_VALUE;
            int next = (mid +1 < N)? nums[mid +1] : Integer.MAX_VALUE;
            
            if(mid == 0) {
                if(num < next) return num;
                else return -1;
                
            } else if(mid == N -1) {
                if(prev < num) return num;
                else return -1;
            } else {
                
                if(prev < num && num < next) return num;
                if(evenPos) {
                    if(num == next) {
                        low = mid +1;
                    } else {
                        high = mid -1;
                    }
                } else {
                    if(prev == num) {
                        low = mid +1;
                    } else {
                        high = mid -1;
                    }
                }
                
            }
            
        }
        
        return -1;
    }
}