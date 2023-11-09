class Solution {
    private final int MOD = 1000_000_000 +7;
    
    public int countHomogenous(String s) {
        int ans = 0;
        int streakCount = 0;
        char ch = s.charAt(0);
        
        for(char currCh :s.toCharArray()) {
            if(currCh == ch) {
                streakCount++;
            } else {
                ch = currCh;
                streakCount = 1;
            }
            ans = (ans +streakCount) %MOD;
        }
        
        return ans;
    }
}