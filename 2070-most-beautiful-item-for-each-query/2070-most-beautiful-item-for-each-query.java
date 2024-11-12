class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] -b[0]);
        
        int currMax = 0;
        for(int i = 0; i < items.length; i++) {
            currMax = Math.max(currMax, items[i][1]);
            items[i][1] = currMax;
        }
        
        int[] maxBeauties = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            maxBeauties[i] = getMaxValue(items, queries[i]);
        }
        
        return maxBeauties;
    }
    
    private int getMaxValue(int[][] items, int price) {
        int lowIdx = 0, highIdx = items.length -1;
        
        int maxValue = 0;
        while(lowIdx <= highIdx) {
            int midIdx = lowIdx +((highIdx -lowIdx) /2);
            if(items[midIdx][0] > price) {
                highIdx = midIdx -1;
            } else {
                maxValue = Math.max(maxValue, items[midIdx][1]);
                lowIdx = midIdx +1;
            }
        }
        
        return maxValue;
    }
    
}