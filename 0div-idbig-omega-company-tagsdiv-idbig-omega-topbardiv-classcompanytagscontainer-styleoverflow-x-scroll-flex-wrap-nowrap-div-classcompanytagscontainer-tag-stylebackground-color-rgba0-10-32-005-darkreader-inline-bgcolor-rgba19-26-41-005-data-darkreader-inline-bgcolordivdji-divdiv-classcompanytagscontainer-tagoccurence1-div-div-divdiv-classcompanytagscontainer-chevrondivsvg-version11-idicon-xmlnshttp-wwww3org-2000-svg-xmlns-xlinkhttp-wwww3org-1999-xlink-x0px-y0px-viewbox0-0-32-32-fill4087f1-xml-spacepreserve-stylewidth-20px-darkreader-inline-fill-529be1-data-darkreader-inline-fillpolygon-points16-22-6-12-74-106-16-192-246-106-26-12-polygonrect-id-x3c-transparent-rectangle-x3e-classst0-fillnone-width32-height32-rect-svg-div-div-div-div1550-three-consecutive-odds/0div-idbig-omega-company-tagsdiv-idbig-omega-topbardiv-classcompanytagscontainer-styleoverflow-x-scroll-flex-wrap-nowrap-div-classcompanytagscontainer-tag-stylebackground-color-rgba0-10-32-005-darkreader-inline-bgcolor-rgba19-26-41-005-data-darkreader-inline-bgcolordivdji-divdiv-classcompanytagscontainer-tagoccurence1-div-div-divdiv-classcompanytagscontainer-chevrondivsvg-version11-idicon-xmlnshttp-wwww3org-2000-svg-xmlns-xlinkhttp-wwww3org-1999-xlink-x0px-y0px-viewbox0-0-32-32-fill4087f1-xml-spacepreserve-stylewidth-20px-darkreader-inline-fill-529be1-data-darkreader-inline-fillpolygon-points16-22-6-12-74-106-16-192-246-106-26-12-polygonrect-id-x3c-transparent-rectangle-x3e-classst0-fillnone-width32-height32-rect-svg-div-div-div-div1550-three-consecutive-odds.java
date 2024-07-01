class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        final int N = arr.length;
        int odds = 0;
        int i = 0, j = 0;
        
        while(j < 3 && j < N) {
            if((arr[j] &1) == 1) odds++;
            j++;
        }
        if(odds == 3) return true;
        
        while(j < N) {
            if((arr[i] &1) == 1) odds--;
            if((arr[j] &1) == 1) odds++;
            if(odds == 3) return true;
            i++;
            j++;
        }
        
        return false;
    }
}