class Solution {
    public int maxWidthRamp(int[] nums) {
        // two pointer
        
        final int N = nums.length;
        int[] maxValue = new int[N];
        maxValue[N -1] = nums[N -1];
        
        for(int i = N -2; i >= 0; i--) {
            maxValue[i] = Math.max(nums[i], maxValue[ i +1]);
        }
        
        int maxDis = 0;
        
        int i = 0, j = 1;
        while(i < N && j < N) {
            if(nums[i] <= maxValue[j]) {
                maxDis = Math.max(maxDis, j -i);
                j++;
            } else {
                i++;
            }
        }
        
        return maxDis;
    }
}