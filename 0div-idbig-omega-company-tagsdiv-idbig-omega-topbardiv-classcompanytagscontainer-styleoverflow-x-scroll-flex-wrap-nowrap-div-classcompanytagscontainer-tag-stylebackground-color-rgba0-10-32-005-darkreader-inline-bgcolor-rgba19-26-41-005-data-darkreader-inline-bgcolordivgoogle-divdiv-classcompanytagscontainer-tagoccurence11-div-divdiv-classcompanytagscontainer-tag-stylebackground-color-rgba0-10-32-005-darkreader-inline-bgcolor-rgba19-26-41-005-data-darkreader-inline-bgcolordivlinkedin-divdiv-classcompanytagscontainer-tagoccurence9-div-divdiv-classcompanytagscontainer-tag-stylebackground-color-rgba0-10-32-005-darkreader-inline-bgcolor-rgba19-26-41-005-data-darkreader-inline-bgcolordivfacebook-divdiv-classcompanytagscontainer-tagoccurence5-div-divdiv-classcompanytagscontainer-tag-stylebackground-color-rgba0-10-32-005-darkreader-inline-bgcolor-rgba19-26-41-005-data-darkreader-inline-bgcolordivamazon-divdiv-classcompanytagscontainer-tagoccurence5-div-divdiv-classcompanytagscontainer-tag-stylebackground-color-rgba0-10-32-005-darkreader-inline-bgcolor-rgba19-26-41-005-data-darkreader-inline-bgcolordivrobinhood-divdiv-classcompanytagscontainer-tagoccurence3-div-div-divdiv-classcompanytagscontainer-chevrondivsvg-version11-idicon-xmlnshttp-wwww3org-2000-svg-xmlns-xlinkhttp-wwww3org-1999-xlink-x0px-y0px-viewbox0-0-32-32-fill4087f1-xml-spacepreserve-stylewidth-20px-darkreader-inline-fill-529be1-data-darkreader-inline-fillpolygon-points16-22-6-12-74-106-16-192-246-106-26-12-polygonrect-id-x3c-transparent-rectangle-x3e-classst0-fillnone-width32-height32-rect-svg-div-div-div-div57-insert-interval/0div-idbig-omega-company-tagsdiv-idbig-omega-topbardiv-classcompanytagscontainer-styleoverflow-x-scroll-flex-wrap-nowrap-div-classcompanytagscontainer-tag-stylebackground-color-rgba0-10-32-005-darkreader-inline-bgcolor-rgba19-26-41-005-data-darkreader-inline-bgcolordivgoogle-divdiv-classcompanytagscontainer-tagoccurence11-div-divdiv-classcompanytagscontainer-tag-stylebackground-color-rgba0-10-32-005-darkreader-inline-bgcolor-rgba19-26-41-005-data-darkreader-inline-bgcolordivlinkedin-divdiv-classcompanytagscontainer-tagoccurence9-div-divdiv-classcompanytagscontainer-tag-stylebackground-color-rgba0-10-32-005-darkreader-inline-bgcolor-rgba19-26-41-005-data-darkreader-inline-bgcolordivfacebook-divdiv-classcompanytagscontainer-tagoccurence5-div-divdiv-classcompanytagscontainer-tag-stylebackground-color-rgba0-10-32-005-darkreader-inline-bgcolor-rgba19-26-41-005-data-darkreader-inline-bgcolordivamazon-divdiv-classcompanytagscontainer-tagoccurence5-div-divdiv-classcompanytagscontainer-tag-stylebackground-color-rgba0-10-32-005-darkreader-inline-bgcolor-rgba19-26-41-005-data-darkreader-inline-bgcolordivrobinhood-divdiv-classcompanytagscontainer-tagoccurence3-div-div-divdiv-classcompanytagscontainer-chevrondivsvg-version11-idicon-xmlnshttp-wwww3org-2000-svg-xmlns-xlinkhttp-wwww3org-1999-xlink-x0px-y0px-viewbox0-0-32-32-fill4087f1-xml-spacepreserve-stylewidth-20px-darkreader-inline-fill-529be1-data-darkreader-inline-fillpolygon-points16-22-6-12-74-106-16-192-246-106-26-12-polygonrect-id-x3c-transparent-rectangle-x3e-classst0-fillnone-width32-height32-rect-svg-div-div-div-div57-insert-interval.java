class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        final int N = intervals.length;
        List<int[]> mergedIntervals = new ArrayList<>();
        
        int i = 0;
        while(i < N && intervals[i][1] < newInterval[0]) {
            mergedIntervals.add(intervals[i]);
            i++;
        }
        
        while(i < N && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        mergedIntervals.add(newInterval);
        
        while(i < N) {
            mergedIntervals.add(intervals[i]);
            i++;
        }
        
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}