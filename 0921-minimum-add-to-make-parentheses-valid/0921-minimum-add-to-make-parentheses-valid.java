class Solution {
    public int minAddToMakeValid(String s) {
        int colseBrac = 0;
        int openBrac = 0;
        
        for(char brac :s.toCharArray()) {
            if(brac == ')' && openBrac > 0) {
                openBrac--;
            } else if(brac == ')'){
                colseBrac++;
            } else {
                openBrac++;
            }
        }
        
        return openBrac +colseBrac;
    }
}