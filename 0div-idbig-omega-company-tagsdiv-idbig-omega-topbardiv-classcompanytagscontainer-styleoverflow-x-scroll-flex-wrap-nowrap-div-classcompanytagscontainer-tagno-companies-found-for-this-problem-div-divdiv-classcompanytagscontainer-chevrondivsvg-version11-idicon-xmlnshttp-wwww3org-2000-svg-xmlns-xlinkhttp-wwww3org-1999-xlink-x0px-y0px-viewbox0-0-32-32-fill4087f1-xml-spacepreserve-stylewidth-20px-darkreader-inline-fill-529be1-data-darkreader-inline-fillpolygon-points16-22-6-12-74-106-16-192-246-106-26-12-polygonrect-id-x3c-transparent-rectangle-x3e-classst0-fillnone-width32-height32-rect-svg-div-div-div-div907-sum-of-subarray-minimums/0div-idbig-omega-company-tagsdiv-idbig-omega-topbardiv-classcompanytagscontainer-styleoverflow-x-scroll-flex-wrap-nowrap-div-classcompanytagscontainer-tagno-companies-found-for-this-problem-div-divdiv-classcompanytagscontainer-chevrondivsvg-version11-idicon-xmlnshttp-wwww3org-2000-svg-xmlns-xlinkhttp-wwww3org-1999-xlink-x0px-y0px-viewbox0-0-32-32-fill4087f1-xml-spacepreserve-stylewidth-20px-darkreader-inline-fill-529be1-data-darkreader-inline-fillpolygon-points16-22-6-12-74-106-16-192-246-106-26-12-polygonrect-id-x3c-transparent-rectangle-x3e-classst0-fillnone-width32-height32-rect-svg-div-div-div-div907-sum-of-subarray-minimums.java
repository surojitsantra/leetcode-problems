class Solution {
    private final int MOD = 1000000000 +7;
    public int sumSubarrayMins(int[] arr) {
        final int N = arr.length;
        
        int[] leftBigCount = getLeftBigCount(arr, N);
        int[] rightBigCount = getRightBigCount(arr, N);
        
        int minSum = 0;
        
        for(int i = 0; i < N; i++) {
            int freq = (int)(((long)leftBigCount[i] *rightBigCount[i]) %MOD);
            int sum = (int)(((long)arr[i] *freq) %MOD);
            minSum = (minSum +sum) %MOD;
        }

        return minSum;
    }
    
    private int[] getLeftBigCount(int[] arr, final int N) {
        int[] leftBigCount = new int[N];
        
        Stack<Integer> helperStack = new Stack<>();
        for(int i = 0; i < N; i++) {
            while(!helperStack.isEmpty() && arr[helperStack.peek()] > arr[i]) helperStack.pop();
            if(helperStack.isEmpty()) leftBigCount[i] = i +1;
            else leftBigCount[i] = i -helperStack.peek();
            helperStack.push(i);
        }
        
        return leftBigCount;
    }
    
    private int[] getRightBigCount(int[] arr, final int N) {
        int[] rightBigCount = new int[N];
        
        Stack<Integer> helperStack = new Stack<>();
        for(int i = N -1; i >= 0; i--) {
            while(!helperStack.isEmpty() && arr[helperStack.peek()] >= arr[i]) helperStack.pop();
            if(helperStack.isEmpty()) rightBigCount[i] = N -i;
            else rightBigCount[i] = helperStack.peek() -i;
            helperStack.push(i);
        }
        
        return rightBigCount;
    }
    
}