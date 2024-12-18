class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> amagramMap = new HashMap<>();
        
        for(String word :strs) {
            String convertedWord = convert(word);
            
            amagramMap.putIfAbsent(convertedWord, new ArrayList<>());
            amagramMap.get(convertedWord).add(word);
            
        }
        
        return new ArrayList<>(amagramMap.values());
        
    }
    
    private String convert(String word) {
        int[] charFreq = new int[26];
        
        for(char ch :word.toCharArray()) {
            charFreq[ch -'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(charFreq[i] > 0) {
                char ch = (char)(i +'a');
                sb.append(ch);
                sb.append(String.valueOf(charFreq[i]));
            }
        }
        
        return sb.toString();
    }
    
}