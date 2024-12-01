class Solution {
    public String minWindow(String s, String t) {
        final int N = s.length();
        Map<Character, Integer> charCount = new HashMap<>();
        
        for(char ch :t.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) +1);
        }
        
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int i = -1, j = -1;
        for(int end = 0; end < N; end++) {
            char endChar = s.charAt(end);
            if(charCount.containsKey(endChar)) {
                charCount.put(endChar, charCount.getOrDefault(endChar, 0) -1);
            }
            
            while(start <= end
                 && allZero(charCount)) {
                char startChar = s.charAt(start);
                if(charCount.containsKey(startChar)) {
                    charCount.put(startChar, charCount.getOrDefault(startChar, 0) +1);
                }
                if(end -start +1 < minLen) {
                    minLen = end -start +1;
                    i = start;
                    j = end;
                }
                start++;
            }
            
        }
        
        if(i == -1) return "";
        return s.substring(i, j+1);
        
    }
    
    private boolean allZero(Map<Character, Integer> charCount) {
        for(int value :charCount.values()) {
            if(value > 0) return false;
        }
        return true;
    }
    
}