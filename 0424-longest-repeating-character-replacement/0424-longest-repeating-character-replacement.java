class Solution {
    public int characterReplacement(String s, int k) {
        final int N = s.length();
        
        int[] charCount = new int[26];
        int start = 0;
        int maxCharCount = 0;
        int maxLen = 0;
        for(int end = 0; end < N; end++) {
            charCount[s.charAt(end) -'A']++;
            
            maxCharCount = Math.max(maxCharCount, charCount[s.charAt(end) - 'A']);
            
            while(end -start +1 -maxCharCount > k) {
                charCount[s.charAt(start) -'A']--;
                start++;
                maxCharCount = getMaxCount(charCount);
            }
            
            maxLen = Math.max(maxLen, end -start +1);
            
        }
        
        return maxLen;
    }
    
    private int getMaxCount(int[] charCount) {
        int maxCharCount = 0;
        for(int count :charCount) {
            maxCharCount = Math.max(maxCharCount, count);
        }
        return maxCharCount;
    }
    
}