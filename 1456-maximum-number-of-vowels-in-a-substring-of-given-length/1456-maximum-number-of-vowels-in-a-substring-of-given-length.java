class Solution {
    public int maxVowels(String s, int k) {
        int i = 0, j = 0;
        int currVowel = 0;
        while(j < k) {
            if(isVowel(s.charAt(j++))) currVowel++;
        }
        
        int ans = currVowel;
        while(j < s.length()) {
            if(isVowel(s.charAt(i++))) currVowel--;
            if(isVowel(s.charAt(j++))) currVowel++;
            ans = Math.max(ans, currVowel);
        }
        
        return ans;
    }
    
    private boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}