class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        final int N = nums.length;
        int[] setBitCount = new int[32];
        int minSubarrayLen = Integer.MAX_VALUE;
        
        int i = 0, j = 0;
        while(i < N && j < N) {
            addNumInSetBitCount(nums[j], setBitCount);
            while(i <= j && convertNumber(setBitCount) >= k) {
                minSubarrayLen = Math.min(minSubarrayLen, j -i +1);
                removeNumInSetBitCount(nums[i], setBitCount);
                i++;
            }
            j++;
        }
        
        return (minSubarrayLen == Integer.MAX_VALUE)? -1 : minSubarrayLen;
    }
    
    private void addNumInSetBitCount(int num, int[] setBitCount) {
        final int N = setBitCount.length;
        for(int i = 0; i < 32; i++) {
            if((num &(1 <<i)) > 0) {
                setBitCount[i]++;
            }
        }
    }
    
    private void removeNumInSetBitCount(int num, int[] setBitCount) {
        final int N = setBitCount.length;
        for(int i = 0; i < 32; i++) {
            if((num &(1 <<i)) > 0) {
                setBitCount[i]--;
            }
        }
    }
    
    private int convertNumber(int[] setBitCount) {
        int num = 0;
        for(int i = 0; i < 32; i++) {
            if(setBitCount[i] > 0) {
                num = num |(1 <<i);
            }
        }
        return num;
    }
    
}