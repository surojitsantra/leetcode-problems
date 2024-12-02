class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {

        final int N = sentence.length(), M = searchWord.length();
        int pos = 1;
        int i = 0, j = 0;
        while(i < N && j < M) {
            if(sentence.charAt(i) == searchWord.charAt(j)) {
                i++;
                j++;
            } else {
                while(i < N && sentence.charAt(i) != ' ') i++;
                i++;
                pos++;
                j = 0;
            }
        }
        
        return (j >= M)? pos : -1;
    }
}