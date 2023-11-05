class Solution {
    public int getWinner(int[] arr, int k) {
        final int N = arr.length;
        
        int i = 0, j = 1;
        int maxNo = arr[0];
        int consecutiveWinCount = 0;
        
        while(j < N) {
            int firstNo = arr[i];
            int secondNo = arr[j];
            
            maxNo = Math.max(maxNo, secondNo);
            
            if(firstNo > secondNo) {
                consecutiveWinCount++;
                j++;
            } else {
                consecutiveWinCount = 1;
                i = j;
                j++;
            }
            
            if(consecutiveWinCount == k) return Math.max(firstNo, secondNo);
            
        }
        
        return maxNo;
    }
}