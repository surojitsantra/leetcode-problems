class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        final int N = happiness.length;
        Arrays.sort(happiness);
        long maxHappiness = 0;
        
        for(int i = 0; i < k; i++) {
            int happy = happiness[N -1 -i] -i;
            if(happy <= 0) return maxHappiness;
            maxHappiness += happy;
        }
        
        return maxHappiness;
    }
}