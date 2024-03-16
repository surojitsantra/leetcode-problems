class Solution {
    public int findMaxLength(int[] nums) {
        final int N = nums.length;
        
        Map<Integer, Integer> sumIdx = new HashMap<>();
        
        int maxSize = 0;
        int currSum = 0;
        for(int i = 0; i < N; i++) {
            int num = (nums[i] == 0)? -1 : 1;
            currSum += num;
            if(currSum == 0) {
                maxSize = i +1;
            } else if(sumIdx.containsKey(currSum)) {
                maxSize = Math.max(maxSize, i -sumIdx.get(currSum));
            } else {
                sumIdx.put(currSum, i);
            }
        }
        
        return maxSize;
        
    }
}