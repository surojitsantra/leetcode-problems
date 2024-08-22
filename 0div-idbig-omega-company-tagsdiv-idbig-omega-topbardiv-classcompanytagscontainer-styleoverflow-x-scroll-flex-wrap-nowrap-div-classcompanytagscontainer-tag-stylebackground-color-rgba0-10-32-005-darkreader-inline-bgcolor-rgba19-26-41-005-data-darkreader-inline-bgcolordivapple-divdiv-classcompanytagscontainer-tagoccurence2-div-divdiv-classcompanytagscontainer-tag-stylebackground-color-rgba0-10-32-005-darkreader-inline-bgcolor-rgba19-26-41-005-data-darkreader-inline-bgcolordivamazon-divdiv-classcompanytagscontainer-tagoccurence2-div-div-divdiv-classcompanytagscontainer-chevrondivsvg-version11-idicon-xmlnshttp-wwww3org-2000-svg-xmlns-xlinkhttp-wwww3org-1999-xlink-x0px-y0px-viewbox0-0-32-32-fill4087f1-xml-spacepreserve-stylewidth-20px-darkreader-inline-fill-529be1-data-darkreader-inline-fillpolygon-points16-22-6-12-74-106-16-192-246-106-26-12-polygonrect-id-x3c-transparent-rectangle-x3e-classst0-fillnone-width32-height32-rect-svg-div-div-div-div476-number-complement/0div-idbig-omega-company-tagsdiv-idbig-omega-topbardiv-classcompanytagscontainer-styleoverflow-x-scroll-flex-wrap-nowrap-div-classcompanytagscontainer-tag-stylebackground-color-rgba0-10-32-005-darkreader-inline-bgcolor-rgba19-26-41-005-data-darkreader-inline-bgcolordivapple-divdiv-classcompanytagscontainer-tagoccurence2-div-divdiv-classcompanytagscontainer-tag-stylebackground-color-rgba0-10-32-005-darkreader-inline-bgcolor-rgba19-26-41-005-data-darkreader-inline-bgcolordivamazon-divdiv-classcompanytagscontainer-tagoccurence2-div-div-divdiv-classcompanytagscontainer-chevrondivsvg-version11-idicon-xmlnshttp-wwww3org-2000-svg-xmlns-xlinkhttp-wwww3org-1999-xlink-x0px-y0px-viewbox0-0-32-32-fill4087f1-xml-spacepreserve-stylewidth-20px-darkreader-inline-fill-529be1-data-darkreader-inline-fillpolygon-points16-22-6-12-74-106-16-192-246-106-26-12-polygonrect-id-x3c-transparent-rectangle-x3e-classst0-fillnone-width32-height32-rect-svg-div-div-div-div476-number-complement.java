class Solution {
    public int findComplement(int num) {
        int flip = 0;
        int i = 0;
        while(num > 0) {
            int bit = ((num &1) == 1) ? 0 : 1;
            flip = (int)(Math.pow(2, i) *bit) +flip;
            num = num >>1;
            i++;
        }
        
        return flip;
    }
}