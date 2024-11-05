class Solution {
    public int minChanges(String s) {
        final int N = s.length();
        
        int count = 0;
        for(int i = 0; i < N; i+= 2) {
            if(s.charAt(i) != s.charAt(i +1)) count++;
        }
        return count;
    }
}