class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        final int N = hand.length;
        if(N %groupSize != 0) return false;
        
        int group = N /groupSize;
        
        NavigableMap<Integer, Integer> numsFreq = new TreeMap<>();
        for(int num :hand) {
            numsFreq.put(num, numsFreq.getOrDefault(num, 0) +1);
        }
        
        while(group-- > 0 && !numsFreq.isEmpty()) {
            int currNum = -1;
            int sz = groupSize;
            
            while(sz-- > 0 && !numsFreq.isEmpty()) {
                Integer nextNum = numsFreq.ceilingKey(currNum +1);
                if(nextNum == null || (currNum != -1 && currNum +1 != nextNum)) {
                    return false;
                }
                
                numsFreq.put(nextNum, numsFreq.getOrDefault(nextNum, 0) -1);
                if(numsFreq.get(nextNum) == 0) {
                    numsFreq.remove(nextNum);
                }
                
                currNum = nextNum;
            }
            if(sz > 0) return false;
        }
        
        return (group <= 0);
    }
}