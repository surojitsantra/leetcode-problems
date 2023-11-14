class Solution {
    public int countPalindromicSubsequence(String s) {
        final int N = s.length();
        
        int[][] letterPos = new int[26][2];
        for(int[] pos :letterPos) Arrays.fill(pos, -1);
        
        for(int i = 0; i < N; i++) {
            char ch = s.charAt(i);
            int idx = ch -'a';
            if(letterPos[idx][0] == -1) letterPos[idx][0] = i;
            letterPos[idx][1] = i;
        }
        
        int ans = 0;
        
        for(int i = 0; i < 26; i++) {
            char ch = (char)('a' +i);
            int start = letterPos[i][0];
            int end = letterPos[i][1];
            
            int noOfUniqueChar = findUniqueChars(s, start +1, end -1);
            
            ans += noOfUniqueChar;
            
        }
        
        return ans;
    }
    
    private int findUniqueChars(String s, int start, int end) {
        Set<Character> uniqueChars = new HashSet<>();
        
        for(int i = start; i <= end; i++) {
            uniqueChars.add(s.charAt(i));
        }
        
        return uniqueChars.size();
    }
    
}