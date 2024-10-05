class Solution {
    public boolean checkInclusion(String s1, String s2) {
        final int M = s1.length();
        final int N = s2.length();
        
        if(M > N) return false;
        
        int[] charFreq1 = new int[26];
        int[] charFreq2 = new int[26];
        
        for(int i = 0; i < M; i++) {
            int idx1 = s1.charAt(i) -'a';
            int idx2 = s2.charAt(i) -'a';
            
            charFreq1[idx1]++;
            charFreq2[idx2]++;
        }
        
        int matchChars = 0;
        
        for(int i = 0; i < 26; i++) {
            if(charFreq1[i] == charFreq2[i]) matchChars++;
        }
        
        int i = 0, j = M;
        while(j < N) {
            int left = s2.charAt(i) -'a';
            int right = s2.charAt(j) -'a';
            
            if(matchChars == 26) {
                return true;
            }
            
            charFreq2[right]++;
            if(charFreq1[right] == charFreq2[right]) {
                matchChars++;
            } else if(charFreq1[right] == charFreq2[right] -1) {
                matchChars--;
            }
            
            charFreq2[left]--;
            if(charFreq1[left] == charFreq2[left]) {
                matchChars++;
            } else if(charFreq1[left] == charFreq2[left] +1) {
                matchChars--;
            }
            
            i++;
            j++;
        }
        
        return matchChars == 26;
    }
}