class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length == 0 && n == 1) return 1;
        
        Map<Integer, Integer> trustCounter = new HashMap<>();
        
        for(int[] t :trust) {
            int p1 = t[0], p2 = t[1];
            trustCounter.put(p1, trustCounter.getOrDefault(p1, 0) -1);
            trustCounter.put(p2, trustCounter.getOrDefault(p2, 0) +1);
        }
        
        for(Map.Entry<Integer, Integer> entry :trustCounter.entrySet()) {
            int trustFactor = entry.getValue();
            
            if(trustFactor == n -1) return entry.getKey();
            
        }
        
        return -1;
    }
}