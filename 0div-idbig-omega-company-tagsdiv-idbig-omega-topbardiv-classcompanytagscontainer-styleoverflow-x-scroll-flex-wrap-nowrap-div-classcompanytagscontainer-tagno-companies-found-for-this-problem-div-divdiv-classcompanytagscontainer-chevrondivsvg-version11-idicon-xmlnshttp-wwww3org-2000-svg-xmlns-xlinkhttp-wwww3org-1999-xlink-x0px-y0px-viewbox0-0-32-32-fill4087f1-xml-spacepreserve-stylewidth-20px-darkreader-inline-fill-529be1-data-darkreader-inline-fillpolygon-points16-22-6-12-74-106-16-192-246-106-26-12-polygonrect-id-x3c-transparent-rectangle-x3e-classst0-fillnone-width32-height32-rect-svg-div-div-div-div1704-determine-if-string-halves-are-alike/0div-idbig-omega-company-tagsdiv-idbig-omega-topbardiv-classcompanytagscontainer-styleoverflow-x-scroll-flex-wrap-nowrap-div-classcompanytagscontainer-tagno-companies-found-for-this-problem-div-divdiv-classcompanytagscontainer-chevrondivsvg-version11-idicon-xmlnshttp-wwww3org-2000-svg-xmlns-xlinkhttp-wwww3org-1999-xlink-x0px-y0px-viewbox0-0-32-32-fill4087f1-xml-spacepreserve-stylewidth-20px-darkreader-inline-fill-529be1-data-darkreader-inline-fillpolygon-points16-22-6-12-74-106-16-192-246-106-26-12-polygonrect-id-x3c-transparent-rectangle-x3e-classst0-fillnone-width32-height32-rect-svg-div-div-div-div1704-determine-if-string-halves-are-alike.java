class Solution {
    public boolean halvesAreAlike(String s) {
        final int N = s.length();
        int halves = N >>1;
        int vowelsCount = 0;
        
        for(int i = 0; i < N; i++) {
            if(isVowel(s.charAt(i))) {
                if(i < halves) vowelsCount++;
                else vowelsCount--;
            }
        }
        
        return (vowelsCount == 0);
    }
    
    private boolean isVowel(char ch) {
        return(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
         || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }
    
}