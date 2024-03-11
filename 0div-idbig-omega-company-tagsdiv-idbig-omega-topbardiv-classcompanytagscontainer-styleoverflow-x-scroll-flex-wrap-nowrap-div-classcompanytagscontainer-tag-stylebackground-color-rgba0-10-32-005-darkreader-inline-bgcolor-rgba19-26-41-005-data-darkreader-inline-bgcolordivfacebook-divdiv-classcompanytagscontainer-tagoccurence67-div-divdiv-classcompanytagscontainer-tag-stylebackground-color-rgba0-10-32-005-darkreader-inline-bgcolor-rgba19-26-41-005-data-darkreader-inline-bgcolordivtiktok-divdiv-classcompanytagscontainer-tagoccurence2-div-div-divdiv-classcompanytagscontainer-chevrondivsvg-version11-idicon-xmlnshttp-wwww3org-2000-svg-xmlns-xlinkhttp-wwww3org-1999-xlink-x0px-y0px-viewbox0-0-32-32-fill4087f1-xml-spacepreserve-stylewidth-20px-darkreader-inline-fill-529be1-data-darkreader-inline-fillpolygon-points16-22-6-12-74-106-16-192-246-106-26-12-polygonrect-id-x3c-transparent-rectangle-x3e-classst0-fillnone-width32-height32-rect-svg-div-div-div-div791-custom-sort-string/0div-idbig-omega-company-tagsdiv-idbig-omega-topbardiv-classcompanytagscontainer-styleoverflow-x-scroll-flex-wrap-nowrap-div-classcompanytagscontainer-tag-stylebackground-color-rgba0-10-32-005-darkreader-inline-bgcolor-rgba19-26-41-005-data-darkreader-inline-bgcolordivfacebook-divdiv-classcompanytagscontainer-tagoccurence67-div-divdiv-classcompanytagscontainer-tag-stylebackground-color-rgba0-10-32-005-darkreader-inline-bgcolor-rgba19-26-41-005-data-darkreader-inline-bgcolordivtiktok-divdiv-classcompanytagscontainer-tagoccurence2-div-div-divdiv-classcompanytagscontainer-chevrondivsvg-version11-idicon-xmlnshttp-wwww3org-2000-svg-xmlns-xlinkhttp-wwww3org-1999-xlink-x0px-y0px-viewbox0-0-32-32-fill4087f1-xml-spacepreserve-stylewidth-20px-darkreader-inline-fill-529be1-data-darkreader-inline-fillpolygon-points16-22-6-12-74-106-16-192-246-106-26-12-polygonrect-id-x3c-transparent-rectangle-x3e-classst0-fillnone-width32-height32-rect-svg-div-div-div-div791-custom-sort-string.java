class Solution {
    public String customSortString(String order, String s) {
        int[] charFreq = new int[26];
        
        for(char ch :s.toCharArray()) charFreq[ch -'a']++;
        
        StringBuilder sb = new StringBuilder();
        
        for(char ch :order.toCharArray()) {
            int idx = ch -'a';
            while(charFreq[idx] > 0) {
                sb.append(ch);
                charFreq[idx]--;
            }
        }
        
        for(int i = 0; i < 26; i++) {
            while(charFreq[i] > 0) {
                sb.append((char)('a' +i));
                charFreq[i]--;
            }
        }
        
        return sb.toString();
    }
}