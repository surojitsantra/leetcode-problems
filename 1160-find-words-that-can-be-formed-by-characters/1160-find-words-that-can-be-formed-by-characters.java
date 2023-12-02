class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charFreq = new int[26];
        
        for(char ch :chars.toCharArray()) {
            int idx = ch -'a';
            charFreq[idx]++;
        }
        
        int count = 0;
        for(String word :words) {
            int[] tempCharFreq = charFreq.clone();
            
            int streak = 0;
            for(char ch :word.toCharArray()) {
                int idx = ch -'a';
                if(tempCharFreq[idx] < 1) break;
                tempCharFreq[idx]--;
                streak++;
            }
            
            if(streak == word.length()) count += streak;
            
        }
        
        return count;
    }
}