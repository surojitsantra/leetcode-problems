class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1) {
            return '0';
        }
        
        int size = (1 <<n) -1;
        int half = size /2;
        if(k == half +1) {
            return '1';
        } else if(k <= half) {
            return findKthBit(n -1, k);
        } else {
            int idx = half -(k -half) +2;
            char bit = findKthBit(n -1, idx);
            return (bit == '0')? '1' : '0';
        }
        
    }
}