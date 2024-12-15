class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int N = nums.length;
        
        int[] product = new int[N];
        
        int currProd = 1;
        for(int i = 0; i < N; i++) {
            product[i] = currProd;
            currProd *= nums[i];
        }
        
        currProd = 1;
        for(int i = N -1; i >= 0; i--) {
            product[i] = currProd *product[i];
            currProd *= nums[i];
        }
        
        return product;
    }
}