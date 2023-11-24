class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        
        int i = 0, j = piles.length -1;
        int ans = 0;
        
        while(i < j) {
            ans += piles[j -1];
            i++;
            j -=2;
        }
        
        return ans;
    }
}