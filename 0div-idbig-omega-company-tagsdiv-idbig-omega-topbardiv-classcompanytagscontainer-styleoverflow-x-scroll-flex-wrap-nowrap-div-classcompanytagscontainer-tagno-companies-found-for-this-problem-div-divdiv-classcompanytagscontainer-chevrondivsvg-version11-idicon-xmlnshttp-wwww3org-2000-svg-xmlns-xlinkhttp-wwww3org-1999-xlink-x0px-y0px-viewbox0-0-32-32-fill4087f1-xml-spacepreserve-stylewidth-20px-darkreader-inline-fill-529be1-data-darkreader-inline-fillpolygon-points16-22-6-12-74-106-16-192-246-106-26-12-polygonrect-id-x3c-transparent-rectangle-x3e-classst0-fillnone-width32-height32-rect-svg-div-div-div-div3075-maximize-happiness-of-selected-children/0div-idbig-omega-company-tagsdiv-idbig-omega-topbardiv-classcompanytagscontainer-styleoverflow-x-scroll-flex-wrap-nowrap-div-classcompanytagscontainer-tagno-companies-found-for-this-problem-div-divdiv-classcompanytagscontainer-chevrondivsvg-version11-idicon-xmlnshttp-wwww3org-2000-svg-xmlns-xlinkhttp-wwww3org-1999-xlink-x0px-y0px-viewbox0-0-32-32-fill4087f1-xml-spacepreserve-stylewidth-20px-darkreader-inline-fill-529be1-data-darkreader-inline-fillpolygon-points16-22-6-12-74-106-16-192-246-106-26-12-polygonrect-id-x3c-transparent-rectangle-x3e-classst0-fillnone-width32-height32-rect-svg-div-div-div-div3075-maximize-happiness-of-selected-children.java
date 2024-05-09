class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int happy :happiness) {
            maxHeap.add(happy);
        }
        
        long maxHapiness = 0;
        
        for(int i = 0; i < k; i++) {
            int happy = maxHeap.poll() -i;
            if(happy <= 0) return maxHapiness;
            maxHapiness += happy;
        }
        
        return maxHapiness;
    }
}