class Solution {
    public boolean isCircularSentence(String sentence) {
        final int N = sentence.length();
        
        if(sentence.charAt(0) != sentence.charAt(N -1)) {
            return false;
        }
        
        int i = 1;
        while(i < N) {
            if((sentence.charAt(i) == ' ') && (sentence.charAt(i -1) != sentence.charAt(i +1))) {
                return false;
            }
            i++;
        }
        
        return true;
    }
}