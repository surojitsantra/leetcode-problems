class Solution {
    private final int MOD = 1000_000_000 +7;
    public int countHomogenous(String s) {
        final int N = s.length();
        
        int ans = 0;
        char ch = s.charAt(0);
        int count = 0;
        for(int i = 0; i < N; i++) {
            char currCh = s.charAt(i);
            if(currCh == ch) {
                count++;
            } else {
                ch = currCh;
                count = 1;
            }
            
            ans = ((ans %MOD) +(count %MOD)) %MOD;
            
        }
        
        return ans;
    }
}