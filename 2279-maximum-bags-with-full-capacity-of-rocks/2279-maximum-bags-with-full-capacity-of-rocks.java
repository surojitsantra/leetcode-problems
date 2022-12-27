class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        final int N = capacity.length;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(int i = 0; i < N; i++) {
            minHeap.add(capacity[i] -rocks[i]);
        }
        
        int fullBags = 0;
        
        while(additionalRocks > 0 && !minHeap.isEmpty()) {
            additionalRocks -= minHeap.poll();
            if(additionalRocks >= 0) fullBags++;
        }
        
        return fullBags;
    }
}