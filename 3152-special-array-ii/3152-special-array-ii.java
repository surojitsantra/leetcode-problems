class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        final int N = nums.length;
        
        int[] errors = new int[N];
        for(int i = 1; i < N; i++) {
            int prev = nums[i -1];
            int curr = nums[i];
            
            errors[i] = errors[i -1];
            if(Math.abs(prev -curr) %2 == 0) {
                errors[i] += 1;
            }
            
        }
        
        boolean[] res = new boolean[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int s = queries[i][0], e = queries[i][1];
            
            res[i] = (errors[e] == errors[s]);
            
        }
        
        return res;
        
    }
}