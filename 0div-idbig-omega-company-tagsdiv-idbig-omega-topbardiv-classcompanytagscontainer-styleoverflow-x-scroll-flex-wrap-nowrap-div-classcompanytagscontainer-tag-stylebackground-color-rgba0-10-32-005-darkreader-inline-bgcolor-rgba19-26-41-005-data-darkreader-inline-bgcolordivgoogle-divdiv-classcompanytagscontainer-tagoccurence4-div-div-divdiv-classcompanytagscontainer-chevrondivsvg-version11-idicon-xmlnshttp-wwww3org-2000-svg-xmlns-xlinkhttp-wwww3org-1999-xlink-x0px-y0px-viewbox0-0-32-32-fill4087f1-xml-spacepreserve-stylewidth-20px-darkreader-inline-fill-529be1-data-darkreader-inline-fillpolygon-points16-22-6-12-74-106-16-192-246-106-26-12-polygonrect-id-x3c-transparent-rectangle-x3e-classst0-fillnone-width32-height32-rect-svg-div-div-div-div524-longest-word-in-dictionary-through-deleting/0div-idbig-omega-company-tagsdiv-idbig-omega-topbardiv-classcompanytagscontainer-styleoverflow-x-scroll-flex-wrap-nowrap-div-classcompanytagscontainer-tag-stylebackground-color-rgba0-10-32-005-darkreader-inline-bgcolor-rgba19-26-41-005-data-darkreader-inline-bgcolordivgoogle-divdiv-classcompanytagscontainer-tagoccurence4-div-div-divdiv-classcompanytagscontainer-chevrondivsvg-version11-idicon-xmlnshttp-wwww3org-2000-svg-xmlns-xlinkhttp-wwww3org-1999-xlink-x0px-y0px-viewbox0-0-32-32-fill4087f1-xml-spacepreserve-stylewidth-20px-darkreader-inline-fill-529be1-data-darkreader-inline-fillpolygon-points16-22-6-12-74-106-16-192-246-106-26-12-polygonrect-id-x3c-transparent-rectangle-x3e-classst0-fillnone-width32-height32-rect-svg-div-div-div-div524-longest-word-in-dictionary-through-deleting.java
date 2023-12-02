class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
        Map<Character, TreeSet<Integer>> charIdx = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charIdx.putIfAbsent(ch, new TreeSet<>());
            charIdx.get(ch).add(i);
        }
        
        String ans = "";
        
        for(String word : dictionary) {
            boolean good = true;
            int lastUsedIdx = -1;

            for(char ch :word.toCharArray()) {
                TreeSet<Integer> chatIndexes = charIdx.get(ch);
                if(chatIndexes == null || chatIndexes.isEmpty() || chatIndexes.ceiling(lastUsedIdx +1) == null) {
                    good = false;
                    break;
                }
                lastUsedIdx = chatIndexes.ceiling(lastUsedIdx +1);
            }
            
            if(good) {
                ans = compareWord(ans, word);
            }
        }
        
        return ans;
    }
    
    private String compareWord(String str1, String str2) {
        if(str1.length() > str2.length()) return str1;
        if(str1.length() < str2.length()) return str2;
        
        for(int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            
            if(ch1 < ch2) return str1;
            if(ch1 > ch2) return str2;
            
        }
        
        return str1;
    }
}