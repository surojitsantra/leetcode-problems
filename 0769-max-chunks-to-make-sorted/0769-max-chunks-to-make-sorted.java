class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int tillMax = 0;
        
        for(int i = 0; i < arr.length; i++) {
            tillMax = Math.max(tillMax, arr[i]);
            if(i == tillMax) {
                chunks++;
            }
        }
        
        return chunks;
    }
}