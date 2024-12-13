class Solution {
    public long findScore(int[] nums) {
        final int N = nums.length;
        
        int[][] numsWithIdx = new int[N][2];
        for(int i = 0; i < N; i++) {
            numsWithIdx[i] = new int[]{nums[i], i};
        }
        
        Arrays.sort(numsWithIdx, (a, b) -> {
            if(a[0] == b[0]) return a[1] -b[1];
            return a[0] -b[0];
        });
        
        long score = 0;
        boolean[] marked = new boolean[N];
        
        for(int i = 0; i < N; i++) {
            int num = numsWithIdx[i][0];
            int idx = numsWithIdx[i][1];
            
            if(!marked[idx]) {
                score += num;
                marked[idx] = true;
                
                if(idx -1 >= 0) {
                    marked[idx -1] = true;
                }
                if(idx +1 < N) {
                    marked[idx +1] = true;
                }
                
            }
            
        }
        
        return score;
    }
}