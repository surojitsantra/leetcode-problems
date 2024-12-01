class Solution {
    public int numberOfSubstrings(String s) {
        final int N = s.length();
        int count = 0;
        int[] lastSeen = new int[]{-1, -1, -1};
        for(int i = 0; i < N; i++) {
            if(s.charAt(i) -'a' < 3) {
                lastSeen[s.charAt(i) -'a'] = i;
            }
            
            int firstSeen = getFirstSeen(lastSeen);
            if(firstSeen >= 0) {
                count += firstSeen +1;
            }
        }
        
        return count;
    }
    
    private int getFirstSeen(int[] lastSeen) {
        int firstSeen = Integer.MAX_VALUE;
        for(int seen :lastSeen) {
            firstSeen = Math.min(firstSeen, seen);
        }
        return firstSeen;
    }
    
}