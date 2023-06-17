class Solution {
    
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        
        Map<Integer, Map<Integer, Long>> dp = new HashMap<>();
        
        long ans = minOps(arr1, 0, -1, arr2, dp);
        
        if(ans >= Integer.MAX_VALUE) return -1;
        
        return (int)ans;
        
    }
    
    private long minOps(int[] arr1, int idx1, int prevVal, int[] arr2, Map<Integer, Map<Integer, Long>> dp) {
        final int N = arr1.length;
        
        if(idx1 >= N) return 0;
        
        if(dp.containsKey(idx1) && dp.get(idx1).containsKey(prevVal)) 
            return dp.get(idx1).get(prevVal);
        
        long ops1 = Integer.MAX_VALUE;
        
        int currVal = arr1[idx1];
        if(prevVal < currVal) {
            ops1 = minOps(arr1, idx1 +1, currVal, arr2, dp);
        }
        
        long ops2 = Integer.MAX_VALUE;
        
        int bigger = getBigger(arr2, prevVal);
        if(bigger != -1)
            ops2 = 1 +minOps(arr1, idx1 +1, bigger, arr2, dp);
        
        long res = 0;
        
        if(ops2 == Integer.MAX_VALUE) res = ops1;
        
        else res = Math.min(ops1, ops2);
        
        dp.putIfAbsent(idx1, new HashMap<>());
        dp.get(idx1).put(prevVal, res);
        
        return res;
    }
    
    private int getBigger(int[] nums, int target) {
        int ans = -1;
        
        int low = 0, high = nums.length -1;
        
        while(low <= high) {
            int mid = (high -low)/2 +low;
            if(nums[mid] > target) {
                ans = nums[mid];
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return ans;
    }
    
}