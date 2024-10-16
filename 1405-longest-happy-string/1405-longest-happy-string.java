class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int[] count = new int[] {a, b, c};
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            int maxCountIdx = getMaxCoundIdx(count);
            if(maxCountIdx == -1) break;
            
            char ch = (char)('a' +maxCountIdx);
            int ansLength = sb.length();
            if(ansLength >= 2 
              && sb.charAt(ansLength -1) == ch
              && sb.charAt(ansLength -2) == ch) {
                maxCountIdx = getSecondMaxCoundIdx(count);
            }
            
            if(maxCountIdx == -1) break;
            
            ch = (char)('a' +maxCountIdx);
            sb.append(ch);
            
            count[maxCountIdx]--;
            
        }
        
        return sb.toString();
    }
    
    private int getMaxCoundIdx(int[] count) {
        int idx = -1;
        int maxVal = 0;
        
        for(int i = 0; i < count.length; i++) {
            if(maxVal < count[i]) {
                maxVal = count[i];
                idx = i;
            }
        }
        
        return idx;
    }
    
    private int getSecondMaxCoundIdx(int[] count) {
        int maxValIdx = getMaxCoundIdx(count);
        if(maxValIdx == -1) return -1;
        
        int maxVal = 0;
        int idx = -1;
        
        for(int i = 0; i < count.length; i++) {
            if(i == maxValIdx) continue;
            if(maxVal < count[i]) {
                maxVal = count[i];
                idx = i;
            }
        }
        
        return idx;
    }
    
}