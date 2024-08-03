class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> numsFreq = new HashMap<>();
        
        for(int num :arr) {
            numsFreq.put(num, numsFreq.getOrDefault(num, 0) +1);
        }
        
        for(int num :target) {
            int freq = numsFreq.getOrDefault(num, 0);
            if(freq == 0) return false;
            numsFreq.put(num, freq -1);
        }
        
        return true;
    }
}