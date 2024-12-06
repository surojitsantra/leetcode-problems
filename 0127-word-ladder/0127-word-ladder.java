class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDist = new HashSet<>(wordList);
        
        Queue<String> hq = new LinkedList<>();
        hq.add(beginWord);
        
        int level = 0;
        while(!hq.isEmpty()) {
            int sz = hq.size();
            while(sz-- > 0) {
                String word = hq.poll();
                if(endWord.equals(word)) {
                    return level +1;
                }
                
                for(int i = 0; i < word.length(); i++) {
                    StringBuilder sb = new StringBuilder(word);
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        sb.setCharAt(i, ch);
                        if(wordDist.contains(sb.toString())) {
                            hq.add(sb.toString());
                            wordDist.remove(sb.toString());
                        }
                    }
                }
            }
            level++;
        }
        
        return 0;
    }
}