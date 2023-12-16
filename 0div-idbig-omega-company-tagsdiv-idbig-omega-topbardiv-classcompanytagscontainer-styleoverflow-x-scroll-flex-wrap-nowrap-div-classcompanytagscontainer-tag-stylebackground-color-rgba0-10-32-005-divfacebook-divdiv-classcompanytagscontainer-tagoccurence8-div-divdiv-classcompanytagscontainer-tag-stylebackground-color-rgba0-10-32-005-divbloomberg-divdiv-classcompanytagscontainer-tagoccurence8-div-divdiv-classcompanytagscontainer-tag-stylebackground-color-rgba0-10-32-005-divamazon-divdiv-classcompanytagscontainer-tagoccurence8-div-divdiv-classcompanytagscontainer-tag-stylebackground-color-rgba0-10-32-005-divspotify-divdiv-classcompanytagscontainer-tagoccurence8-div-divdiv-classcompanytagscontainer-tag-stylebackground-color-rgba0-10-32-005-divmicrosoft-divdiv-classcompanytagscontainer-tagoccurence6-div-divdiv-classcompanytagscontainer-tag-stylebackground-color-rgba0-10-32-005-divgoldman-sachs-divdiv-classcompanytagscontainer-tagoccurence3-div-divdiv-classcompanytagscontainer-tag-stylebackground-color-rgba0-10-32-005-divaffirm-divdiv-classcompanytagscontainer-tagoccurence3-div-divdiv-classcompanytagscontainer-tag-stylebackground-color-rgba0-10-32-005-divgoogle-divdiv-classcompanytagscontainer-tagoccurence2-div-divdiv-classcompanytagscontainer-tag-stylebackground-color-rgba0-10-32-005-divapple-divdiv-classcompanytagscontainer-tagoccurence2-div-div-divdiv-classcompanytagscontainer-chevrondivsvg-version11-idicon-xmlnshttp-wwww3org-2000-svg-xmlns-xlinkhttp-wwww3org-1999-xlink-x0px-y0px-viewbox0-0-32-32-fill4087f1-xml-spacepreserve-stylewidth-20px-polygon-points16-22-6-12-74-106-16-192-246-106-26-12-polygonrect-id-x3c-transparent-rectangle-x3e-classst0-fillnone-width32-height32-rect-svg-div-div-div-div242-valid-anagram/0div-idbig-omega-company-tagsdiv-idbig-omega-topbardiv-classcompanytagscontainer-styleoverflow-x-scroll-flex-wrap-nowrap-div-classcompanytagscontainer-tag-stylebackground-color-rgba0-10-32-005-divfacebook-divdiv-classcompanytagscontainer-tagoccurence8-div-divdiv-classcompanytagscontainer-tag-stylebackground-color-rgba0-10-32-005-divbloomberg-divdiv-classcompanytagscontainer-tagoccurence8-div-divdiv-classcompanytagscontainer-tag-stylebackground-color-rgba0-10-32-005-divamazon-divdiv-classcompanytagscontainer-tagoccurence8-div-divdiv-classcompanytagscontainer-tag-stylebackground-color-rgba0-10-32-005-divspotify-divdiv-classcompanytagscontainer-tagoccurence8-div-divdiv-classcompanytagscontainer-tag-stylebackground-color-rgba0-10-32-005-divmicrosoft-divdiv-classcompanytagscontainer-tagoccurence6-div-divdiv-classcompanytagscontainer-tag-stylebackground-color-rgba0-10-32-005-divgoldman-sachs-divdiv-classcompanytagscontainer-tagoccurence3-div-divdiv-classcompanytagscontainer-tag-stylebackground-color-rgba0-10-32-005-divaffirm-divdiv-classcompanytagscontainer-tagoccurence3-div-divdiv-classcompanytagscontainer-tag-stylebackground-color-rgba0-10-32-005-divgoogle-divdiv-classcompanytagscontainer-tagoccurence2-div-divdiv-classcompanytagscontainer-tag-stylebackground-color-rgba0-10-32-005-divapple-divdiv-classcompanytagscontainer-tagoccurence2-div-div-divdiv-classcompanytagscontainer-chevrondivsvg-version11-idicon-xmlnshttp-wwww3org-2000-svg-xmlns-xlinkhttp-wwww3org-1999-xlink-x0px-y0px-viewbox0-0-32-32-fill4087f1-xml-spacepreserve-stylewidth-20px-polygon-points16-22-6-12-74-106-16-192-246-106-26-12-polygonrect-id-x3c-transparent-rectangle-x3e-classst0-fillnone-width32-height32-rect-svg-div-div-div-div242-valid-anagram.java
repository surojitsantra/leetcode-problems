class Solution {
    public boolean isAnagram(String s, String t) {
        final int M = s.length(), N = t.length();
        if(M != N) return false;
        int[] charFreq = new int[26];
        
        for(int i = 0; i < M; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            charFreq[ch1 -'a']++;
            charFreq[ch2 -'a']--;
            
        }
        
        for(int freq :charFreq) {
            if(freq != 0) return false;
        }
        return true;
    }
}