class Solution {
    public int lengthOfLastWord(String s) {
        final int N = s.length();
        
        StringBuilder sb = new StringBuilder();
        int i = N -1;
        while(i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while(i >= 0 && s.charAt(i) != ' ') {
            sb.append(s.charAt(i));
            i--;
        }
        
        return sb.length();
    }
}