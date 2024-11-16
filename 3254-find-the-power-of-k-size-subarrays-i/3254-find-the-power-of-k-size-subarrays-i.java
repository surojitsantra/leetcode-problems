class Solution {
    public int[] resultsArray(int[] nums, int k) {
        final int N = nums.length;
        Deque<Integer> helperQueue = new LinkedList<>();
        int[] result = new int[N -k +1];
        
        int i = 0, j = 0, x = 0;
        while(j < N) {
            if(j < k) {
                while(!helperQueue.isEmpty() && nums[helperQueue.peekLast()] +1 != nums[j]) {
                    helperQueue.removeLast();
                }
                helperQueue.addLast(j);
                if(j == k -1) {
                    result[x++] = (helperQueue.size() == k)? nums[helperQueue.peekLast()] : -1;
                }
                j++;
            } else {
                if(!helperQueue.isEmpty() && helperQueue.peekFirst() == i) {
                    helperQueue.removeFirst();
                }
                i++;
                
                while(!helperQueue.isEmpty() && nums[helperQueue.peekLast()] +1 != nums[j]) {
                    helperQueue.removeLast();
                }
                helperQueue.addLast(j);
                result[x++] = (helperQueue.size() == k)? nums[helperQueue.peekLast()] : -1;
                j++;
            }
        }
        
        return result;
    }
}