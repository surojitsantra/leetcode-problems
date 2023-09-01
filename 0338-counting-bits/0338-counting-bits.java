class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n +1];
        
        ans[0] = 0;
        
        int j = 1;
        int k = 0;
        
        for(int i = 1; i <= n; i++) {
            ans[i] = ans[k++] +1;
            if(k == j) {
                k = 0;
                j = j <<1;
            }
            
        }
        
        return ans;
    }
}