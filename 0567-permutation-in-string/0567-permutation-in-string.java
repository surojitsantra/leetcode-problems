class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()) {
            return false;
        }
        
        int[] charFreq = new int[26];
        for(char ch :s1.toCharArray()) {
            charFreq[ch -'a']++;
        }
        
        for(int i = 0; i < s1.length(); i++) {
            int idx = s2.charAt(i) -'a';
            charFreq[idx]--;
        }
        
        if(isSame(charFreq)) {
            return true;
        }
        
        int i = 0, j = s1.length();
        while(j < s2.length()) {
            int idx1 = s2.charAt(i) -'a';
            int idx2 = s2.charAt(j) -'a';
            
            charFreq[idx1]++;
            charFreq[idx2]--;
            i++;
            j++;
            
            if(isSame(charFreq)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean isSame(int[] charFreq) {
        for(int freq :charFreq) {
            if(freq != 0) {
                return false;
            }
        }
        return true;
    }
    
}