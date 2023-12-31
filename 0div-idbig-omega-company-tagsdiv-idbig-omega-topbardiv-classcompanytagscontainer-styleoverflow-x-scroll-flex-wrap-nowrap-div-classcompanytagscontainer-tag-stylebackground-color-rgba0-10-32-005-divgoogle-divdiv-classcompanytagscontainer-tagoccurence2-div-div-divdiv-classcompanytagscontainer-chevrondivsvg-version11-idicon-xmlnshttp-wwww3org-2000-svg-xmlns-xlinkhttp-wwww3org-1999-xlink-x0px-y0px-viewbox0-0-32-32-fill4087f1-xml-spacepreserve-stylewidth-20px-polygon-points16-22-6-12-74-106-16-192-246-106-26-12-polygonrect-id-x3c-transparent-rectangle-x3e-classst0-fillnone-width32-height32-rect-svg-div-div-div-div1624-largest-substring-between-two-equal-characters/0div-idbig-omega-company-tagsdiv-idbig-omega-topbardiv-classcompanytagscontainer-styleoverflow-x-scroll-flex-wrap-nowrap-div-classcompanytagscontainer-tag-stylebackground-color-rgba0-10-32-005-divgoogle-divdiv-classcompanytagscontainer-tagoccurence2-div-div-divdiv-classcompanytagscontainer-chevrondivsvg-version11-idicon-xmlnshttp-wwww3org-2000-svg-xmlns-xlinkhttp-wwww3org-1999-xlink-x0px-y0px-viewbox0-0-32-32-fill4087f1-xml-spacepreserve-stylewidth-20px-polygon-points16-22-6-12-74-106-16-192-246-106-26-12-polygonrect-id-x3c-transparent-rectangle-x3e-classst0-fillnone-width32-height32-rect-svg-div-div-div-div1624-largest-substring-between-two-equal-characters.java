class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Pair<Integer, Integer>[] points = new Pair[26];
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch -'a';
            if(points[idx] == null) {
                points[idx] = new Pair<>(i, i);
            } else {
                points[idx] = new Pair<>(points[idx].getKey(), i);
            }
        }
        
        int maxSubStringLen = -1;
        
        for(Pair<Integer, Integer> pair :points) {
            if(pair == null) continue;
            int start = pair.getKey();
            int end = pair.getValue();
            maxSubStringLen = Math.max(maxSubStringLen, (end -start) +1 -2);
        }
        
        return maxSubStringLen;
    }
}