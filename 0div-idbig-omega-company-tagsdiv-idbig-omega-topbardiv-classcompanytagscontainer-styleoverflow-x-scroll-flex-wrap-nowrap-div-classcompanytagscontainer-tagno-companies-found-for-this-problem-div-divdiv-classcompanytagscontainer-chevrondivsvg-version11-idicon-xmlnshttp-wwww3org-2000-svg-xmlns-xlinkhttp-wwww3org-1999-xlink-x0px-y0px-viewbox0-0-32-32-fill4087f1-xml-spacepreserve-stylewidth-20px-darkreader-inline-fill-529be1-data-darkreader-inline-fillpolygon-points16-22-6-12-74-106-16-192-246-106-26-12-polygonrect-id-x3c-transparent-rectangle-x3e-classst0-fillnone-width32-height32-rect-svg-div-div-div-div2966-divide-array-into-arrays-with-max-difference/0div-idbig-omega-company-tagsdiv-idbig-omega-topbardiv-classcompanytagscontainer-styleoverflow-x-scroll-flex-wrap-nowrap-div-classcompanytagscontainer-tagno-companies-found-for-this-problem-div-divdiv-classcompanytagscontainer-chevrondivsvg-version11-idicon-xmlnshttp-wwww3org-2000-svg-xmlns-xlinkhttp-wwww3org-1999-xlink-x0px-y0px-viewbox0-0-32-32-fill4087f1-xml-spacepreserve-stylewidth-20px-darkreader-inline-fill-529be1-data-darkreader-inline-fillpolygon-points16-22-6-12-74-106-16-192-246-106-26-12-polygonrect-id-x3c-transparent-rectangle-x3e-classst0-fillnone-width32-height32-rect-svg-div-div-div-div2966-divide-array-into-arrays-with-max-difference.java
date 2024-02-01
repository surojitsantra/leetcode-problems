class Solution {
    public int[][] divideArray(int[] nums, int k) {
        final int N = nums.length;
        if(N %3 != 0) return new int[0][0];
        
        Arrays.sort(nums);
        
        int[][] ans = new int[N /3][3];
        
        for(int i = 0; i < N; i++) {
            int idx = i /3;
            if(i %3 == 0) {
                ans[idx][0] = nums[i];
            } else if(nums[i] -ans[idx][0] > k) return new int[0][0];
            else {
                ans[idx][i %3] = nums[i];
            }
        }
        
        return ans;
    }
}