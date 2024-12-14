class Solution {
    public long continuousSubarrays(int[] nums) {
        final int N = nums.length;
        long count = 0;
        
        int start = 0;
        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();
        
        for(int end = 0; end < N; end++) {
            
            while(!maxQueue.isEmpty() 
                  && nums[end] >= nums[maxQueue.peekLast()]) {
                maxQueue.removeLast();
            }
            while(!minQueue.isEmpty() 
                  && nums[end] <= nums[minQueue.peekLast()]) {
                minQueue.removeLast();
            }
            
            maxQueue.addLast(end);
            minQueue.addLast(end);
            
            while(nums[maxQueue.peekFirst()] -nums[minQueue.peekFirst()] > 2) {
                
                if(start == maxQueue.peekFirst()) {
                    maxQueue.removeFirst();
                }
                while(start == minQueue.peekFirst()) {
                    minQueue.removeFirst();
                }
                start++;
            }
            
            count += (end -start +1);
            
        }
        
        return count;
    }
    
}