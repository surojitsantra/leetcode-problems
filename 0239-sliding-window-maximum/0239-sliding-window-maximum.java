class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        final int N = nums.length;
        int[] ans = new int[N -k +1];
        
        
        Deque<Integer> deque = new LinkedList<>();
        
        int j = 0;
        while(j < k) {
            if(deque.isEmpty() || nums[deque.peekLast()] > nums[j]) {
                deque.addLast(j++);
            } else {
                deque.pollLast();
            }
        }
        
        ans[0] = nums[deque.peekFirst()];
        
        int i = 0;
        
        while(j < N) {
            if(!deque.isEmpty() && i == deque.peekFirst()) {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[j] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(j++);
            i++;
            
            ans[i] = nums[deque.peekFirst()];
        }
        
        return ans;
    }
}