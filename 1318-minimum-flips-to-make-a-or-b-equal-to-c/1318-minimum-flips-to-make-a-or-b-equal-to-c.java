class Solution {
    public int minFlips(int a, int b, int c) {
        int minFlip = 0;
        
        while(a != 0 || b != 0 || c != 0) {
            if((c &1) == 0) {
                if((a &1) == 1) minFlip++;
                if((b &1) == 1) minFlip++;
            } else {
                if((a &1) == 0 && (b &1) == 0) minFlip++;
            }
            
            a = a >>1;
            b = b >>1;
            c = c >>1;
            
        }
        
        return minFlip;
    }
}