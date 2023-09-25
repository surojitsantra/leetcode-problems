class Solution {
    public char findTheDifference(String s, String t) {
        int[] charFreq = new int[26];
        
        for(char ch :t.toCharArray()) charFreq[ch -'a']++;
        for(char ch :s.toCharArray()) charFreq[ch -'a']--;
        
        for(int i = 0; i < 26; i++) {
            if(charFreq[i] == 1) return (char)('a' +i);
        }
        
        return '0';
    }
}