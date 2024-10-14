class Solution {
    public long maxKelements(int[] nums, int k) {
        long sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num : nums) {
            maxHeap.add(num);
        }
        
        for(int i = 0; i < k; i++) {
            int num = maxHeap.poll();
            sum += num;
            maxHeap.add((num +2) /3);
        }        
        
        return sum;
    }
}