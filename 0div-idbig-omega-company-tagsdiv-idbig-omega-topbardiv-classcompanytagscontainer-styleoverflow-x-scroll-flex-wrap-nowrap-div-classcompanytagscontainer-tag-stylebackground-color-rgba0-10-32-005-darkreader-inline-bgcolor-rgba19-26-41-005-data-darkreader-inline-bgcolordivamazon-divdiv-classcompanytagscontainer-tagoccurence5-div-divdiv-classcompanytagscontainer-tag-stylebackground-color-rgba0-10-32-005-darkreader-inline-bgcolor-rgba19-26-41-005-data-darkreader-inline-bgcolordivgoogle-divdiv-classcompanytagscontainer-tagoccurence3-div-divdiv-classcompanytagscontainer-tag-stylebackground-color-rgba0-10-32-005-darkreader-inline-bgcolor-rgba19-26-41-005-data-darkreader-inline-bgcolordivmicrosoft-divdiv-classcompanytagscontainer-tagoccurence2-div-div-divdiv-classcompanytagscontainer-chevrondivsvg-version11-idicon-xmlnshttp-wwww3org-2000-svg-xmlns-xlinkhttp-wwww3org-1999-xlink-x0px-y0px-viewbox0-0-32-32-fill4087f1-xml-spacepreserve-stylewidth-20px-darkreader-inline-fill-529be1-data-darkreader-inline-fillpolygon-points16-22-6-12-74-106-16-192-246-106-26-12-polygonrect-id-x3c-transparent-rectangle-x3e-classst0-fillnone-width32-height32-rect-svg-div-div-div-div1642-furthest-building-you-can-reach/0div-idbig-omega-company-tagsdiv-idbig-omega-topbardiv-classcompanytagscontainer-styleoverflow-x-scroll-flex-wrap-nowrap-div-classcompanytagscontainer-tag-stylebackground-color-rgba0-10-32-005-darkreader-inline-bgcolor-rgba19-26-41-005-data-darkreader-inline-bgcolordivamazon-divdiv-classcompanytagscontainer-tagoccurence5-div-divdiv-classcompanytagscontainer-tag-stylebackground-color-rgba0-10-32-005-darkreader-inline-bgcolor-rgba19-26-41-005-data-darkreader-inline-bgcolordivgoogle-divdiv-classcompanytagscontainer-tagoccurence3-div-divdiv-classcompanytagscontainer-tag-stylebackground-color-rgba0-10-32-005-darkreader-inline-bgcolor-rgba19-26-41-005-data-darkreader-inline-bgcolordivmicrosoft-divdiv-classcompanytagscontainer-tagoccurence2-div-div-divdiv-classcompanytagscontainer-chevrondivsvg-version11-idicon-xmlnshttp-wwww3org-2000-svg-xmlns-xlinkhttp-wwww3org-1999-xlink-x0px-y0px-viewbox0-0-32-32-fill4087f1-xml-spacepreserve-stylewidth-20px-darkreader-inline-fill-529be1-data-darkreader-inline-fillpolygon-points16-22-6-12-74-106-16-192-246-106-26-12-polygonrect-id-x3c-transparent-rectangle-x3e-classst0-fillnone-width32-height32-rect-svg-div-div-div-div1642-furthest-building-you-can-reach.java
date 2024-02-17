class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        final int N = heights.length;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int tillBricksUsed = 0;
        
        for(int i = 0; i < N -1; i++) {
            int heightDiff = heights[i +1] -heights[i];
            if(heightDiff <= 0) continue;
            
            if(bricks -tillBricksUsed >= heightDiff) {
                tillBricksUsed += heightDiff;
                maxHeap.add(heightDiff);
            } else if(ladders > 0) {
                if(!maxHeap.isEmpty() && maxHeap.peek() >= heightDiff) {
                    int topBricks = maxHeap.poll();
                    tillBricksUsed -= topBricks;
                    tillBricksUsed += heightDiff;
                    maxHeap.add(heightDiff);
                }
                
                ladders--;
            } else {
                return i;
            }
            
        }
        
        return N -1;
    }
}