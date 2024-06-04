class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();
        
        int count = 0;
        for(char ch :s.toCharArray()) {
            charFreq.put(ch, charFreq.getOrDefault(ch, 0) +1);
            if((charFreq.get(ch) &1) == 0) {
                count += 2;
            }
        }
        
        if(s.length() > count) {
            count++;
        }
        
        return count;
    }
}