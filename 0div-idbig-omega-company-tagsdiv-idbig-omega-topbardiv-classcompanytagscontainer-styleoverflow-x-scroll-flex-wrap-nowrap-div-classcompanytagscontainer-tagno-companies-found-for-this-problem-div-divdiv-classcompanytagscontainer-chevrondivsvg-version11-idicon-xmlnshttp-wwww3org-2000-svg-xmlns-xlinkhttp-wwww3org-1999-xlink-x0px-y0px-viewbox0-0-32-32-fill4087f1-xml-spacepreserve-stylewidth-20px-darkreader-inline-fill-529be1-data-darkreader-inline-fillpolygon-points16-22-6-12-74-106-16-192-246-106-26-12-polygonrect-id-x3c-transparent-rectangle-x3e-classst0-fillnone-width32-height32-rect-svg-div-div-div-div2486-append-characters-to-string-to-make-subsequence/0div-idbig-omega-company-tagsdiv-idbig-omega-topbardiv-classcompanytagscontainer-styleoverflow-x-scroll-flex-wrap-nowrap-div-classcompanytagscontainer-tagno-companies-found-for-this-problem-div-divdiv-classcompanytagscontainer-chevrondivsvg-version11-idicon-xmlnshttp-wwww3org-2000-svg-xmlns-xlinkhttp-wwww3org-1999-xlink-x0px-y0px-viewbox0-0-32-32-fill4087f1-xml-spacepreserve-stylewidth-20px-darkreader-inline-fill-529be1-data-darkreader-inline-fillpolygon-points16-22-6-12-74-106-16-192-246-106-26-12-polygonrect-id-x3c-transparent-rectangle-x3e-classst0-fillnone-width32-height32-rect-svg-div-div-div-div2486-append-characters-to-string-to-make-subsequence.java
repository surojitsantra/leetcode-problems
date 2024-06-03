class Solution {
    public int appendCharacters(String s, String t) {
        final int M = s.length(), N = t.length();
        int i = 0, j = 0;
        
        while(i < M && j < N) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        
        return N -j;
    }
}