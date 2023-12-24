class Solution {
    public int minOperations(String s) {
        int startWithZero = 0;
        int startWithOne = 0;
        
        for(int i = 0; i < s.length(); i++) {
            int bit = (s.charAt(i) -'0');
            if(bit == 1) {
                if((i &1) == 0) startWithZero++;
                else startWithOne++;
            } else {
                if((i &1) == 0) startWithOne++;
                else startWithZero++;
            }
        }
        return Math.min(startWithZero, startWithOne);
    }
}