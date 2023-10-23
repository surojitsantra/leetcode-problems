class Solution {
public:
    bool isPowerOfFour(int n) {
        if(n < 0) return false;
        
        while(n) {
            if(n&1) {
                if(n == 1) return true;
                return false;
            }
            n = n >> 1;
            if(n&1) return false;
            n = n >> 1;
        }
        return false;
    }
};