class Solution {
    public int[][] merge(int[][] intervals) {
        final int N = intervals.length;
        
        Arrays.sort(intervals, (a, b) -> a[0] -b[0]);
        
        List<Integer[]> mergerdIntervals = new ArrayList<>();
        mergerdIntervals.add(new Integer[] {intervals[0][0], intervals[0][1]});
        
        for(int i = 1; i < N; i++) {
            int[] curr = intervals[i];
            Integer[] prev = mergerdIntervals.get(mergerdIntervals.size() -1);
            
            if(isConflict(prev, curr)) {
                prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                mergerdIntervals.add(new Integer[] {curr[0], curr[1]});
            }
            
        }
        
        int[][] ans = new int[mergerdIntervals.size()][2];
        for(int i = 0; i < mergerdIntervals.size(); i++) {
            ans[i] = new int[] {mergerdIntervals.get(i)[0], mergerdIntervals.get(i)[1]};
        }
        
        return ans;
    }
    
    private boolean isConflict(Integer[] prev, int[] curr) {
        return prev[1] >= curr[0];
    }
    
}