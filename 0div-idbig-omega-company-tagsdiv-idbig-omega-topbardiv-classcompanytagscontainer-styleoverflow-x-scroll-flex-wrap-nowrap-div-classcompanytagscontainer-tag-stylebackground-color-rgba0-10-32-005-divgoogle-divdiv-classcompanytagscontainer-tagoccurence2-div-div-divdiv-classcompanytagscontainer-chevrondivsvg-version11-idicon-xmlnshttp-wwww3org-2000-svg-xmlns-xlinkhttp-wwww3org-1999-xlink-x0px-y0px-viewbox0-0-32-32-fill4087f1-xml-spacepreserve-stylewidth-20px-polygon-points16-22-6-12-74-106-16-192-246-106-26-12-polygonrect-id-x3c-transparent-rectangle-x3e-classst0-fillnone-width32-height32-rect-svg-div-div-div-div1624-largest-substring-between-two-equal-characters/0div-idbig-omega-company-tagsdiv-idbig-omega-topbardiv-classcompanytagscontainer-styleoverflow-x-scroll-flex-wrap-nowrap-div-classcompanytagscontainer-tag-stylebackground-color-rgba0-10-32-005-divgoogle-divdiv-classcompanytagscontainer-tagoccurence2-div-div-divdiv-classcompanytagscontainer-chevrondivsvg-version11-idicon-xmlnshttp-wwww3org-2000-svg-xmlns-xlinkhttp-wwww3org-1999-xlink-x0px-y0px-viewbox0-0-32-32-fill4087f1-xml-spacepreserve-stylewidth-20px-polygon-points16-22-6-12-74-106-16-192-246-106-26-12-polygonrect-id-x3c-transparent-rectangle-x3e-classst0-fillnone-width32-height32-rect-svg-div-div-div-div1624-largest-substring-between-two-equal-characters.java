class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] firstIdx = new int[26];
        Arrays.fill(firstIdx, -1);
        
        int len = -1;
        
        for(int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) -'a';
            if(firstIdx[idx] == -1) firstIdx[idx] = i;
            else {
                len = Math.max(len, i -firstIdx[idx] +1 -2);
            }
        }
        
        return len;
    }
}