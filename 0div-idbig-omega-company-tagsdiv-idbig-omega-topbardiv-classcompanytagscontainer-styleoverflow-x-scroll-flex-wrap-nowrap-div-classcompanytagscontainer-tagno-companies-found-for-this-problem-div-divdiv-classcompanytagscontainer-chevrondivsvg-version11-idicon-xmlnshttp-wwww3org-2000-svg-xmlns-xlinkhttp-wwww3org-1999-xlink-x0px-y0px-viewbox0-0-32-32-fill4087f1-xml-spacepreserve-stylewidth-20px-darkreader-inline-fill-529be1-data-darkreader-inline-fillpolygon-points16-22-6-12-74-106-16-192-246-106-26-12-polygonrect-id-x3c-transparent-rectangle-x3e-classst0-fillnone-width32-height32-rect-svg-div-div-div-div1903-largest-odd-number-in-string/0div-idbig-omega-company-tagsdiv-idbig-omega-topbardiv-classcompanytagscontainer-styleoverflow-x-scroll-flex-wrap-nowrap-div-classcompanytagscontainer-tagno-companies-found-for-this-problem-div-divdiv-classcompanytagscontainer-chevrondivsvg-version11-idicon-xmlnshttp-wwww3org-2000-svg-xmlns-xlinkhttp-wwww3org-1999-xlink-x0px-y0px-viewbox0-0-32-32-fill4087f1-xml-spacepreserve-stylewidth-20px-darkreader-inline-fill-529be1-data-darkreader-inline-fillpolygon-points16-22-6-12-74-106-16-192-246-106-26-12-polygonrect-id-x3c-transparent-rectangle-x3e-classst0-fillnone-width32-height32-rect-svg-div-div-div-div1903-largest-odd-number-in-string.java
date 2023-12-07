class Solution {
    public String largestOddNumber(String num) {
        final int N = num.length();
        
        for(int i = N -1; i >= 0; i--) {
            int ch = num.charAt(i);
            if((ch &1) == 1) return num.substring(0, i+1);
        }
        
        return "";
    }
}