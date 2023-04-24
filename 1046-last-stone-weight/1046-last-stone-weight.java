class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i = 0; i < stones.length; i++){
            pq.add(stones[i]);
        }
        
        while(pq.size() > 1){
            int p = pq.poll();
            int q = pq.poll();
            pq.add(p -q);
        }
        return pq.poll();
        
    }
}