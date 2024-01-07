class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        final int N = nums.length;
        int count = 0;
        
        Map<Long, Integer>[] diffVsFreqMaps = new Map[N];
        for(int i = 0; i < N; i++) diffVsFreqMaps[i] = new HashMap<>();
        
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                long diff = (long)nums[i] -nums[j];
                if(diff <= Integer.MIN_VALUE || diff >= Integer.MAX_VALUE) continue;
                
                int noOfSeqEndsOnJ = diffVsFreqMaps[j].getOrDefault(diff, 0);
                int noOfSeqEndsOnI = diffVsFreqMaps[i].getOrDefault(diff, 0);
                count += noOfSeqEndsOnJ;
                
                diffVsFreqMaps[i].put(diff, noOfSeqEndsOnI +noOfSeqEndsOnJ +1);
            }
        }
        
        return count;
    }
    
}