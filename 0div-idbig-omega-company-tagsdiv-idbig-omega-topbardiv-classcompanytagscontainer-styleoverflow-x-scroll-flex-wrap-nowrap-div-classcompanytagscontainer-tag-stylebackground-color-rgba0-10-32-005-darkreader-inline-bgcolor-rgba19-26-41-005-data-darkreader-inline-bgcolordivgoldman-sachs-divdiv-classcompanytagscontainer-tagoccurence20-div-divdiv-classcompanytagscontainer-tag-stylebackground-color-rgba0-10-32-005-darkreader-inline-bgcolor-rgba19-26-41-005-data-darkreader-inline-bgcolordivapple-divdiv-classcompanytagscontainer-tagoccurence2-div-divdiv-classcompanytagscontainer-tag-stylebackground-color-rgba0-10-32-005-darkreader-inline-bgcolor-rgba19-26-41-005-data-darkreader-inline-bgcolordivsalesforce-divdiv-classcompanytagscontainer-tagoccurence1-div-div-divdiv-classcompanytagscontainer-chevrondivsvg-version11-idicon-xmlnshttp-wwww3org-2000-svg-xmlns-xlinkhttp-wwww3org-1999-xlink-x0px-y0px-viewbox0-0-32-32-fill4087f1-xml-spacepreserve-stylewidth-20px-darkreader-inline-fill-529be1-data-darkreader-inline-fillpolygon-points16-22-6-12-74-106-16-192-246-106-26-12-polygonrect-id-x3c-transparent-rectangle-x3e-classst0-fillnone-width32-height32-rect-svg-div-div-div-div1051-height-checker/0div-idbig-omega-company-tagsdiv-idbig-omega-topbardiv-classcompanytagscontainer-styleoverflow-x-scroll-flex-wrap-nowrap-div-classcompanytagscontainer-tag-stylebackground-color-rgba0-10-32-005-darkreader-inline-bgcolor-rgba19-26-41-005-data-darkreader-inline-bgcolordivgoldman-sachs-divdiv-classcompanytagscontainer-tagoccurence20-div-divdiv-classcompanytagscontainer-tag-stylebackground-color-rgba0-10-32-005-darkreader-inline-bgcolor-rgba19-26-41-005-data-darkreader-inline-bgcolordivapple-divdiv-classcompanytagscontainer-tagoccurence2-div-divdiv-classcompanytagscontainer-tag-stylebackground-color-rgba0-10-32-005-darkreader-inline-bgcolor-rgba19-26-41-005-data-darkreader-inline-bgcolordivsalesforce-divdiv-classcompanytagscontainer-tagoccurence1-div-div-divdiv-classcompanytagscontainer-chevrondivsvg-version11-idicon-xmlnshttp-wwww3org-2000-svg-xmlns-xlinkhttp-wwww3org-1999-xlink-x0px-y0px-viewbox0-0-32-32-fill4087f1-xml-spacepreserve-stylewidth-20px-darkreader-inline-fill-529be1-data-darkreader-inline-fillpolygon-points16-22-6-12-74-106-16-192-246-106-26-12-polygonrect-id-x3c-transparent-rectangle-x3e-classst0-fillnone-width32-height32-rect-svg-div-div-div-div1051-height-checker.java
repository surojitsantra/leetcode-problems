class Solution {
    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        
        for(int h :heights) {
            count[h]++;
        }
        
        int k = 0;
        int ans = 0;
        
        int i = 1;
        while(i <= 100) {
            if(count[i] == 0) {
                i++;
            } else if(i == heights[k]) {
                count[i]--;
                k++;
            } else {
                count[i]--;
                k++;
                ans++;
            }
        }
        
        return ans;
    }
}