class Solution {
    public int lengthOfLongestSubstring(String s) {
        final int N = s.length();
        int lss = 0;
        
        Map<Character, Integer> charCount = new HashMap<>();
        int start = 0;
        for(int end = 0; end < N; end++) {
            char ch = s.charAt(end);
            charCount.put(ch, charCount.getOrDefault(ch, 0) +1);
            
            while(start <= end && charCount.get(ch) > 1) {
                char startChar = s.charAt(start);
                charCount.put(startChar, charCount.get(startChar) -1);
                start++;
            }
            
            lss = Math.max(lss, end -start +1);
        }
        
        return lss;
    }
}