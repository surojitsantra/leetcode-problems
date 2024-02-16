class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        for(int num :arr) numFreq.put(num, numFreq.getOrDefault(num, 0) +1);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(numFreq.values());
        while(!minHeap.isEmpty() && minHeap.peek() <= k) {
            k = k -minHeap.poll();
        }
        
        return minHeap.size();
    }
}