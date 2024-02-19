class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 1) return false;
        
        int setBitCount = 0;
        
        while(n > 0) {
            setBitCount += (n &1);
            if(setBitCount > 1) return false;
            n = (n >>1);
        }
        
        return true;
    }
}