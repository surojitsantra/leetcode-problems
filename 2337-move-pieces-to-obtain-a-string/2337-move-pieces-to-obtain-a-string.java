class Solution {
    public boolean canChange(String start, String target) {
        final int M = start.length(), N = target.length();
        if(M != N) return false;
        
        int startIdx = 0, targetIdx = 0;
        while(startIdx < N || targetIdx < N) {
            while(targetIdx < N && target.charAt(targetIdx) == '_') {
                targetIdx++;
            }
            while(startIdx < N && start.charAt(startIdx) == '_') {
                startIdx++;
            }
            
            if (startIdx == N || targetIdx == N) {
                return startIdx == N && targetIdx == N;
            }
            
            char ch1 = start.charAt(startIdx);
            char ch2 = target.charAt(targetIdx);
            
            if((ch1 != ch2) || (ch1 == 'L' && targetIdx > startIdx) || (ch1 == 'R' && targetIdx < startIdx)) {
                return false;
            }
            startIdx++;
            targetIdx++;
        }
        
        return true;
    }
}