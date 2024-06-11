class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        final int N = arr1.length;
        
        Map<Integer, Integer> numsFreq = new TreeMap<>();
        
        for(int num :arr1) {
            numsFreq.put(num, numsFreq.getOrDefault(num, 0) +1);
        }
        
        int[] sortedArray = new int[N];
        int i = 0;
        
        for(int x :arr2) {
            int freq = numsFreq.getOrDefault(x, 0);
            
            while(freq-- > 0) {
                sortedArray[i++] = x;
            }
            
            if(numsFreq.containsKey(x)) {
                numsFreq.remove(x);
            }
            
        }
        
        for(Map.Entry<Integer, Integer> entry :numsFreq.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            
            while(freq-- > 0) {
                sortedArray[i++] = num;
            }
            
        }
        
        return sortedArray;
    }
}