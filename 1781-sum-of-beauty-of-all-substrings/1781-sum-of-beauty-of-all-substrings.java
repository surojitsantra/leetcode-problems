class Solution {
    public int beautySum(String s) {
        final int N = s.length();
        
        int beautyCount = 0;
        for(int i = 0; i < N; i++) {
            int[] charCount = new int[26];
            for(int j = i; j < N; j++) {
                charCount[s.charAt(j) -'a']++;
                
                beautyCount += getDifference(charCount);
                
            }
        }
        
        return beautyCount;
    }
    
    private int getDifference(int[] charCount) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int val :charCount) {
            if(val != 0) {
                min = Math.min(min, val);
                max = Math.max(max, val);
            }
        }
        
        return max -min;
    }
    
}