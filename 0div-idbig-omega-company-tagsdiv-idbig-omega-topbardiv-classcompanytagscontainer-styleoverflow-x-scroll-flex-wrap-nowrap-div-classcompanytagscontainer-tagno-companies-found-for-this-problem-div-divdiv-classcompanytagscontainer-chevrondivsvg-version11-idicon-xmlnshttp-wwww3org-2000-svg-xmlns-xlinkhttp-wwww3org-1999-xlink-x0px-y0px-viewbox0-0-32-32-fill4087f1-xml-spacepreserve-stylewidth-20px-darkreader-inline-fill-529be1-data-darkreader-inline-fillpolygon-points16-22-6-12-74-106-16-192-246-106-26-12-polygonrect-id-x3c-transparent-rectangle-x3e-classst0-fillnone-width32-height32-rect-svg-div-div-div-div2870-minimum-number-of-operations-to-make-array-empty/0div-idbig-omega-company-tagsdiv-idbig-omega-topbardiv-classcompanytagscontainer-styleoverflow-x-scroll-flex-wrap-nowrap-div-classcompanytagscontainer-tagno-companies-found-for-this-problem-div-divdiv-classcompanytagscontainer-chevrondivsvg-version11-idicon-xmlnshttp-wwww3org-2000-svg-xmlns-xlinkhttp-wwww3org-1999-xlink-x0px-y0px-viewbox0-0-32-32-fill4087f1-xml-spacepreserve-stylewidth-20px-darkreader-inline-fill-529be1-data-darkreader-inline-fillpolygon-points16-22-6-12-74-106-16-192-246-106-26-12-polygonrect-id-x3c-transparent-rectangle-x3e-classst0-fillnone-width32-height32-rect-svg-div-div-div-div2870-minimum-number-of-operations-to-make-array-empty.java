class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> numsFreq = new HashMap<>();
        
        for(int num :nums) numsFreq.put(num, numsFreq.getOrDefault(num, 0) +1);
        
        int minOps = 0;
        
        for(Map.Entry<Integer, Integer> entry :numsFreq.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            
            if(freq == 1) return -1;
            
            minOps += Math.ceil((double) freq /3);
            
        }
        
        return minOps;
    }
}