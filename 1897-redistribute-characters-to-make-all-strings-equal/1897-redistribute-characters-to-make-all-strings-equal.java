class Solution {
    public boolean makeEqual(String[] words) {
        int[] charFreq = new int[26];
        for(String word :words) {
            for(char ch :word.toCharArray()) charFreq[ch -'a']++;
        }
        
        final int N = words.length;
        
        for(int freq :charFreq) {
            if(freq %N != 0) return false;
        }
        
        return true;
    }
}