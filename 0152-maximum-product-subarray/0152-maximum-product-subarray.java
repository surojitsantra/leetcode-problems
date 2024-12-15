class Solution {
    public int maxProduct(int[] nums) {
        final int N = nums.length;
        
        int maxProduct = Integer.MIN_VALUE;
        int currProduct = 1;
        
        for(int i = 0; i < N; i++) {
            currProduct = currProduct *nums[i];
            
            maxProduct = Math.max(maxProduct, currProduct);
            if(currProduct == 0) currProduct = 1;
        }
        
        currProduct = 1;
        for(int i = N -1; i >= 0; i--) {
            currProduct = currProduct *nums[i];
            
            maxProduct = Math.max(maxProduct, currProduct);
            if(currProduct == 0) currProduct = 1;
        }
        
        return maxProduct;
    }
}