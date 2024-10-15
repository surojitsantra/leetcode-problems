class Solution {
    public long minimumSteps(String s) {
        final int N = s.length();
        long swapReq = 0;
        int onceFromLeft = 0;
        
        for(int i = 0; i < N; i++) {
            char ch = s.charAt(i);
            if(ch == '1') {
                onceFromLeft++;
            } else {
                swapReq += onceFromLeft;
            }
        }
        
        return swapReq;
    }
}