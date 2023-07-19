class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[1] == b[1]) return a[0] -b[0];
            return a[1] -b[1];
        });
        
        int ans = 0;
        int end = Integer.MIN_VALUE;
        for(int[] interval :intervals) {
            int start = interval[0];
            if(start < end) {
                ans++;
            } else {
                end = interval[1];
            }
        }
        return ans;
    }
}