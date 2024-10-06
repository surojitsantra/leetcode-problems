class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        final int M = sentence1.length(), N = sentence2.length();
        if(M > N) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        
        int start = 0;
        while(start < words1.length && words1[start].equals(words2[start])) {
            start++;
        }
        
        int end1 = words1.length -1;
        int end2 = words2.length -1;
        
        while(end1 >= 0 && words1[end1].equals(words2[end2])) {
            end1--;
            end2--;
        }
        
        return end1 < start;
    }
}