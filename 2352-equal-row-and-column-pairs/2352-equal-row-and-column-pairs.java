class Solution {
    public int equalPairs(int[][] grid) {
        final int N = grid.length;
        
        Map<String, Integer> helperMap = new HashMap<>();
        
        for(int[] row :grid) {
            StringBuilder rowEle = new StringBuilder();
            for(int num :row) {
                rowEle.append("_" +num);
            }
            
            helperMap.put(rowEle.toString(), helperMap.getOrDefault(rowEle.toString(), 0) +1);
        }
        
        int commonPair = 0;
        
        for(int c = 0; c < N; c++) {
            StringBuilder colEle = new StringBuilder();
            for(int r = 0; r < N; r++) {
                colEle.append("_"+grid[r][c]);
            }
            
            int present = helperMap.getOrDefault(colEle.toString(), 0);
            commonPair += present;
        }
        
        return commonPair;
    }
}