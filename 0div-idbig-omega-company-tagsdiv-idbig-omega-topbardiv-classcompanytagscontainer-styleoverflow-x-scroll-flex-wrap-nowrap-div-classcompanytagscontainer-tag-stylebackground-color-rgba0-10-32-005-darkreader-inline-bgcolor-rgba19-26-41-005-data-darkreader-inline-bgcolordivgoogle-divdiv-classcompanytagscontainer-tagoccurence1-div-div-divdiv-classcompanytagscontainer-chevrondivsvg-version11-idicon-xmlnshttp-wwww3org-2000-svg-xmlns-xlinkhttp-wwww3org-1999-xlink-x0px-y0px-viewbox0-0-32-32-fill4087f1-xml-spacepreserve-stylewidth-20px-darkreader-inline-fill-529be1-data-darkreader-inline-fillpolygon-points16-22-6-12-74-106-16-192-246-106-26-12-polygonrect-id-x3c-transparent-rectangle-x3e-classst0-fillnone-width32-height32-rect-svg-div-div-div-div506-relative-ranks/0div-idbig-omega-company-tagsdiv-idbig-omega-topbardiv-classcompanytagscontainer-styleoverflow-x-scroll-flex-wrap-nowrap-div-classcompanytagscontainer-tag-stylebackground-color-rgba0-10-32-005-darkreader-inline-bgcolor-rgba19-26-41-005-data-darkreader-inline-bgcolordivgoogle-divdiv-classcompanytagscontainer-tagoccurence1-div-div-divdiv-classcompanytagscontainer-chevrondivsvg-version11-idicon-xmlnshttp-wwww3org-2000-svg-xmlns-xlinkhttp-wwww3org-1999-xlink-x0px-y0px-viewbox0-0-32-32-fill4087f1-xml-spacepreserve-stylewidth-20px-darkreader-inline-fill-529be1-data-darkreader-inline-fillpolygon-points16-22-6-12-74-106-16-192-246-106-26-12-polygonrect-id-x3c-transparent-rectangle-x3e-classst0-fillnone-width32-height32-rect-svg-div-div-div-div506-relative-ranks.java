class Solution {
    public String[] findRelativeRanks(int[] score) {
        final int N = score.length;
        String[] medels = new String[N];
        
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>((p1, p2) -> p2.getKey() -p1.getKey());
        
        for(int i = 0; i < N; i++) {
            maxHeap.add(new Pair<>(score[i], i));
        }
        
        if(!maxHeap.isEmpty()) {
            medels[maxHeap.poll().getValue()] = "Gold Medal";
        }
        if(!maxHeap.isEmpty()) {
            medels[maxHeap.poll().getValue()] = "Silver Medal";
        }
        if(!maxHeap.isEmpty()) {
            medels[maxHeap.poll().getValue()] = "Bronze Medal";
        }
        
        int i = 4;
        while(!maxHeap.isEmpty()) {
            medels[maxHeap.poll().getValue()] = String.valueOf(i);
            i++;
        }
        
        return medels;
    }
}