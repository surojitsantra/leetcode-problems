class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numsFreq = new HashMap<>();
        for(int num :arr) numsFreq.put(num, numsFreq.getOrDefault(num, 0) +1);
        
        Set<Integer> uniqueFreq = new HashSet<>();
        
        for(int freq :numsFreq.values()) {
            if(uniqueFreq.contains(freq)) return false;
            uniqueFreq.add(freq);
        }
        
        return true;
    }
}