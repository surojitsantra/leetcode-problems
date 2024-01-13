class Solution {
    public int minSteps(String s, String t) {
        final int N = s.length();
        int[] charFreq = new int[26];
        
        for(int i = 0; i < N; i++) {
            charFreq[s.charAt(i) -'a']++;
            charFreq[t.charAt(i) -'a']--;
        }
        
        int count = 0;
        for(int freq :charFreq) {
            if(freq > 0) count += freq;
        }
        
        return count;
    }
}