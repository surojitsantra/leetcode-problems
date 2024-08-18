class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> seenNumbers = new HashSet<>();
        int[] primeFactors = { 2, 3, 5 };
        
        minHeap.add(1L);
        seenNumbers.add(1L);
        
        long currentUgly = 1L;
        for(int i = 1; i <= n; i++) {
            currentUgly = minHeap.poll();
            
            for(int prime :primeFactors) {
                long nextUgly = currentUgly * prime;
                if(!seenNumbers.contains(nextUgly)) {
                    seenNumbers.add(nextUgly);
                    minHeap.add(nextUgly);
                }
            }
            
        }
        
        return (int) currentUgly;
    }
}