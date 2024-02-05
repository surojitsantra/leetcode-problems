class Solution {
    public int firstUniqChar(String s) {
        int[] charCountMap = new int[26];
        Arrays.fill(charCountMap, -1);
        
        for(int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) -'a';
            if(charCountMap[idx] == -1) {
                charCountMap[idx] = i;
            } else {
                charCountMap[idx] = -2;
            }
        }
        
        int minIdx = Integer.MAX_VALUE;
        for(int idx :charCountMap) {
            if(idx >= 0) minIdx = Math.min(minIdx, idx);
        }
        
        if(minIdx == Integer.MAX_VALUE) return -1;
        return minIdx;
    }
}