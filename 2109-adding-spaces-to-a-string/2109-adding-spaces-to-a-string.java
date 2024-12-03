class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        final int N = s.length(), M = spaces.length;
        
        int i = 0, j = 0;
        while(i < N) {
            if(j < M && i == spaces[j]) {
                sb.append(" ");
                j++;
            }
            sb.append(s.charAt(i));
            i++;
        }
        
        return sb.toString();
    }
}