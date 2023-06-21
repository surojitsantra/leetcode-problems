class Solution {
    public long minCost(int[] nums, int[] cost) {
        //Bin search
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        
        for(int num :nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }
        
        long ans = 0;
        
        while(low <= high) {
            int mid = (high -low) /2 +low;
            long cost1 = getCost(nums, cost, mid);
            long cost2 = getCost(nums, cost, mid +1);
            
            if(cost1 < cost2) {
                ans = cost1;
                high = mid -1;
            } else {
                low = mid +1;
            }
        }        
        return ans;
    }
    
    private long getCost(int[] nums, int[] cost, int x) {
        long totalCost = 0;
        
        for(int i = 0; i < nums.length; i++) {
            totalCost += (long)cost[i] *Math.abs(x -nums[i]);
        }
        
        return totalCost;
    }
    
}