class Solution {
    public boolean isSubsequence(String s, String t) {
        final int M = s.length(), N = t.length();
        
        int i = 0, j = 0;
        
        while(i < M && j < N) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return (i == M);
    }
}