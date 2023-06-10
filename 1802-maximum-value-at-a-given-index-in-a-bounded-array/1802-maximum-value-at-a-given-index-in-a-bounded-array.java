class Solution {
    public int maxValue(int n, int index, int maxSum) {
        //search space
        int low = 1, high = maxSum;
        
        int ans = 1;
        
        while(low <= high) {
            int mid = (high -low) /2 +low;
            
            if(isPossible(mid, n, index, maxSum)) {
                ans = mid;
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        
        return ans;
    }
    
    
    private boolean isPossible(int mid, int n, int index, int maxSum) {
        int leftSideEle = index;
        int rightSideEle = n -index -1;
        
        long leftSum = getSum(leftSideEle, mid -1);
        long rightSum = getSum(rightSideEle, mid -1);
        
        long totalSum = leftSum +mid +rightSum;
        
        return (totalSum <= maxSum);
    }
    
    private long getSum(int totalLen, int val) {
        long totalSum = 0;
        int decreasingLen = val; //count of decreasing elements [val, val - 1, .., 1]
        
        if (totalLen >= decreasingLen) {
            long currSum = calc(val);
            int remainingSum = totalLen - decreasingLen; //all 1's
            totalSum = currSum + remainingSum;
        } else {
            long lastVal = decreasingLen - totalLen;
            totalSum = calc(val) - calc(lastVal);
        }
        return totalSum;
        
    }
    
    private long calc(long n) {
        return ((n * (n + 1)) / 2);
    }
    
}