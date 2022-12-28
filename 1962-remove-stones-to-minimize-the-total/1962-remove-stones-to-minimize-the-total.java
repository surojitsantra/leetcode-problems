class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        
        for(int pile :piles) maxHeap.add(pile);
        
        for(int i = 1; i <= k; i++) {
            int newPile = (maxHeap.poll() +1) >>1;
            maxHeap.add(newPile);
        }
        
        int totalPiles = 0;
        while(!maxHeap.isEmpty()) {
            totalPiles += maxHeap.poll();
        }
        
        return totalPiles;
    }
}