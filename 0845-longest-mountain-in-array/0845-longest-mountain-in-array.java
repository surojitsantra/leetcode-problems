class Solution {
    public int longestMountain(int[] arr) {
        final int N = arr.length;
        
        int maxMountain = 0;
        
        
        for(int i = 1; i < N -1; i++) {
            int leftSlope = findLeftSlope(arr, i);
            int rightSlope = findRightSlope(arr, i);
            
            if(leftSlope == 0 || rightSlope == 0) continue;
            
            maxMountain = Math.max(maxMountain, leftSlope +rightSlope +1);
            
        }
        
        // for(int i = 0; i < N; i++) {
        //     for(int j = i +2; j < N; j++) {
        //         int currMountain = findMountainSize(arr, i, j);
        //         maxMountain = Math.max(maxMountain, currMountain);
        //     }
        // }
        
        return maxMountain;
    }
    
    private int findLeftSlope(int[] arr, int peak) {
        int slope = 0;
        
        int i = peak -1;
        while(i >= 0 && arr[i] < arr[i +1]) {
            slope++;
            i--;
        }
        
        return slope;
    }
    
    private int findRightSlope(int[] arr, int peak) {
        int slope = 0;
        
        int i = peak +1;
        while(i < arr.length && arr[i -1] > arr[i]) {
            slope++;
            i++;
        }
        
        return slope;
    }
    
    
    private int findMountainSize(int[] arr, int start, int end) {
        int upSlope = 1;
        int downSlope = 0;
        start++;
        
        while(start <= end && arr[start -1] < arr[start]) {
            upSlope++;
            start++;
        }
        
        while(start <= end && arr[start -1] > arr[start]) {
            downSlope++;
            start++;
        }
        
        if(start <= end) return 0;
        
        return upSlope +downSlope;
        
    }
}