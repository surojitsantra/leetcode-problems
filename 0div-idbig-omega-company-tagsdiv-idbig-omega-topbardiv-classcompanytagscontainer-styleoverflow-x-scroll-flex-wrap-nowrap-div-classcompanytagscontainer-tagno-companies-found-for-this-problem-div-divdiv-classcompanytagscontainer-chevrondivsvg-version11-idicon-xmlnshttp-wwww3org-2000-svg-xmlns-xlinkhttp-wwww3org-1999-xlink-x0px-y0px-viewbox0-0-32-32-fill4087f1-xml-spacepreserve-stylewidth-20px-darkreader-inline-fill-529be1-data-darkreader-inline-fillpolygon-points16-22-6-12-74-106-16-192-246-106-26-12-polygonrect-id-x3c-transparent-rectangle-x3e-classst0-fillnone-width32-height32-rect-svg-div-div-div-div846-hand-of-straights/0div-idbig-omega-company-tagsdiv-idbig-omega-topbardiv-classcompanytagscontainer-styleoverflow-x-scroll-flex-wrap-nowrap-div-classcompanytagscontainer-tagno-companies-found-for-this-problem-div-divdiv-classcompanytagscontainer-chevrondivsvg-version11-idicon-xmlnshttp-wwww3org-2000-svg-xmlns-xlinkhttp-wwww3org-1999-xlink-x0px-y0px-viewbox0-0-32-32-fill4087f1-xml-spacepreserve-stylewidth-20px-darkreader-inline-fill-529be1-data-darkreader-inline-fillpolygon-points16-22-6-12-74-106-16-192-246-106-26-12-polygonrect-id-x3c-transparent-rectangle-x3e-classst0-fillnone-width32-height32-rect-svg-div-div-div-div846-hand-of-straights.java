class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        final int N = hand.length;
        if(N %groupSize != 0) return false;
        
        Map<Integer, Integer> numsFreq = new TreeMap<>();
        for(int num :hand) {
            numsFreq.put(num, numsFreq.getOrDefault(num, 0) +1);
        }
        
        while(!numsFreq.isEmpty()) {
            int num = numsFreq.entrySet().iterator().next().getKey();
            
            for(int ele = 1; ele <= groupSize; ele++) {
                
                if(!numsFreq.containsKey(num)) return false;
                numsFreq.put(num, numsFreq.get(num) -1);
                
                if(numsFreq.get(num) == 0) {
                    numsFreq.remove(num);
                }
                
                num++;
            }
        }
        
        return true;
    }
}