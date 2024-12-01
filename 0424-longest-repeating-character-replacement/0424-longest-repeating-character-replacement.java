class Solution {
    public int characterReplacement(String s, int k) {
        final int N = s.length();
        
        int[] charCount = new int[26];
        int start = 0;
        int maxCharFreq = 0;
        int maxLen = 0;
        for(int end = 0; end < N; end++) {
            char endChar = s.charAt(end);
            charCount[endChar -'A']++;
            
            maxCharFreq = Math.max(maxCharFreq, charCount[endChar -'A']);
            int substrLen = end -start +1;
            while(start <= end && substrLen -maxCharFreq > k) {
                char startChar = s.charAt(start);
                charCount[startChar -'A']--;
                start++;
                substrLen--;
            }
            
            maxLen = Math.max(maxLen, end -start +1);
        }
        
        return maxLen;
    }
}