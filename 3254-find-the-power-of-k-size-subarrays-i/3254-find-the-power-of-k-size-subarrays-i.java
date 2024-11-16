class Solution {
    public int[] resultsArray(int[] nums, int k) {
        final int N = nums.length;
        int[] result = new int[N -k +1];
        
        int streak = 1;
        int x = 0;
        for(int j = 0; j < N; j++) {
            if(j -1 >= 0 && nums[j -1] +1 == nums[j]) streak++;
            else streak = 1;
            
            if(j >= k -1) {
                result[x++] = (streak >= k)? nums[j] : -1;
            }
        }
        
        return result;
    }
}