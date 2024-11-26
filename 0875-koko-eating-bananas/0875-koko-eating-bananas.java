class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0, r = 0;
        for(int p :piles) r = Math.max(r, p);
        
        int minTime = r;
        
        while(l <= r) {
            int k = (l +((r -l) /2));
            if(canEat(piles, h, k)) {
                minTime = k;
                r = k -1;
            } else {
                l = k +1;
            }
        }
        
        return minTime;
    }
    
    private boolean canEat(int[] piles, int h, int k) {
        int currTime = 0;
        
        for(int p :piles) {
            currTime += Math.ceil((double)p /k);
            if(currTime > h) return false;
        }
        return true;
    }
    
}