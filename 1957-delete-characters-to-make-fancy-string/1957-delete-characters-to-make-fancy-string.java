class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        
        char currChar = '#';
        int streak = 0;
        for(char ch :s.toCharArray()) {
            if(ch == currChar) {
                streak++;
            } else {
                currChar = ch;
                streak = 1;
            }
            if(streak < 3) {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}