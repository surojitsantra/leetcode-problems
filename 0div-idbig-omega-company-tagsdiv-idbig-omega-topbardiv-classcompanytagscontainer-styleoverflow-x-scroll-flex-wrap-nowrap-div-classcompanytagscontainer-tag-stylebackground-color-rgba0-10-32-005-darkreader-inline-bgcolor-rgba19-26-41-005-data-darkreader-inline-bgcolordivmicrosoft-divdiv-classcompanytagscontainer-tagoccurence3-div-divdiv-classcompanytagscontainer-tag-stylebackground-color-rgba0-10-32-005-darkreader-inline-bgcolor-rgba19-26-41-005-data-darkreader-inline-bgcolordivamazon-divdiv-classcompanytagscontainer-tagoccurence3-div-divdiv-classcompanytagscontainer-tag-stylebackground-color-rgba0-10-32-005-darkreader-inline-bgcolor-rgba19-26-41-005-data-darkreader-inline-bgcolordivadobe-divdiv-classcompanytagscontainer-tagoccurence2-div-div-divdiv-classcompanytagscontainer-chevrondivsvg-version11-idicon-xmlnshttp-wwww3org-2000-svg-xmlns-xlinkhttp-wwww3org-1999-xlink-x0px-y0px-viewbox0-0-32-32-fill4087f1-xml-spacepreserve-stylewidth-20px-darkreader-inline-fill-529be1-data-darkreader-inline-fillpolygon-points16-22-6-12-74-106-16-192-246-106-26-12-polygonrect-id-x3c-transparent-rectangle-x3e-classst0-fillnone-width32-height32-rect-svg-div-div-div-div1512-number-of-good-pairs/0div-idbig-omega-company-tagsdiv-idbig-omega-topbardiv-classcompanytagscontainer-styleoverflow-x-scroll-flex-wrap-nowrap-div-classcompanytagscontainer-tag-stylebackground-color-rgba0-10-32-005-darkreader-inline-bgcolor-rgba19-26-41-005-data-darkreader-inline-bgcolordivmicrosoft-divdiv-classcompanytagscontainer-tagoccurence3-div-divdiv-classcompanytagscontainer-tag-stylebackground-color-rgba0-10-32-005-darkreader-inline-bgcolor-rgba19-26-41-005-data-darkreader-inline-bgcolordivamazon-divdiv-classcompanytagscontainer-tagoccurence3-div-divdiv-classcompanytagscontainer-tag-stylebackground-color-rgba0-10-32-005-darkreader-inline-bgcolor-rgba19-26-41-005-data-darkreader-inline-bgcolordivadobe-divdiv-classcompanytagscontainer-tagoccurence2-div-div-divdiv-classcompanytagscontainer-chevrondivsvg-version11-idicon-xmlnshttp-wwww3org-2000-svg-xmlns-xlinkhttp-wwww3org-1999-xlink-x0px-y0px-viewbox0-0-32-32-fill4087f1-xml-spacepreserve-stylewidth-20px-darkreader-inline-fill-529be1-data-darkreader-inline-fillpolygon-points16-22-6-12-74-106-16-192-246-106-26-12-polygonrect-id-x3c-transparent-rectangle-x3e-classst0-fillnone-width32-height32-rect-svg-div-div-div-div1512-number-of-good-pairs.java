class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> numsFreq = new HashMap<>();
        int goodPairs = 0;
        
        for(int num :nums) {
            int freq = numsFreq.getOrDefault(num, 0);
            goodPairs += freq;
            numsFreq.put(num, freq +1);
        }
        
        return goodPairs;
    }
}