class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        
        Map<String, Integer> wordCount = new HashMap<>();
        
        for(String word :s1.split(" ")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) +1);
        }
        
        for(String word :s2.split(" ")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) +1);
        }
        
        List<String> uncommonWords = new ArrayList<>();
        for(String word: wordCount.keySet()) {
            if(wordCount.get(word) == 1) {
                uncommonWords.add(word);
            }
        }
        return uncommonWords.toArray(new String[uncommonWords.size()]);
    }
}