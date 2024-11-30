class Solution {
    public int trap(int[] height) {
        final int N = height.length;
        
        int[] nge = new int[N];
        int currMax = -1;
        
        for(int i = N -1; i >= 0; i--) {
            if(height[i] >= currMax) {
                nge[i] = -1;
                currMax = height[i];
            } else {
                nge[i] = currMax;
            }
        }
        
        int water = 0;
        currMax = -1;
        for(int i = 0; i < N; i++) {
            int left = (height[i] >= currMax)? -1 : currMax;
            int right = nge[i];
            
            if(left != -1 && right != -1) {
                water += Math.min(left, right) -height[i];
            }
                
            currMax = Math.max(currMax, height[i]);
        }
        
        return water;
    }
}