class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numbersMap = new HashMap<>();
       
        for(int num :nums) {
            numbersMap.put(num, numbersMap.getOrDefault(num, 0) +1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> numbersMap.get(b) -numbersMap.get(a));
        pq.addAll(numbersMap.keySet());
        
        int[] results = new int[k];
        
        for(int i = 0; i < k; i++) {
            results[i] = pq.poll();
        }
        
        return results;
    }
}