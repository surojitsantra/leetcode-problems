class Solution {
    public int maxScore(String s) {
        final int N = s.length();
        int rightOnce = 0;
        for(char ch :s.toCharArray()) rightOnce += (ch -'0');
        
        int leftZeros = 0;
        
        int ans = 0;
        for(int i = 0; i < N -1; i++) {
            int bit = s.charAt(i) -'0';
            leftZeros += (bit == 0)? 1 : 0;
            rightOnce -= bit;
            ans = Math.max(ans, leftZeros +rightOnce);
        }
        
        return ans;
    }
}