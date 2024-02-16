class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        final int N = arr.length;
        
        Map<Integer, Integer> numFreq = new HashMap<>();
        for(int num :arr) numFreq.put(num, numFreq.getOrDefault(num, 0) +1);
        
        int[] countOfFreq = new int[N +1];
        for(int freq :numFreq.values()) {
            countOfFreq[freq]++;
        }
        
        int remainingUniqueElements = numFreq.size();
        for(int i = 1; i < N +1; i++) {
            int numElementsToRemove = Math.min(k / i, countOfFreq[i]);
            k -= (i * numElementsToRemove);
            remainingUniqueElements -= numElementsToRemove;
            if (k < i) {
                return remainingUniqueElements;
            }
        }
        
        return 0;
    }
}