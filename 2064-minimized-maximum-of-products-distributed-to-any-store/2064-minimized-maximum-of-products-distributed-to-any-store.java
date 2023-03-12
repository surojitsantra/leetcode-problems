class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        //Bin serach
        //Search space;
        
        int minProductQty, maxProductQty = Integer.MIN_VALUE;
        for(int quantity :quantities) maxProductQty = Math.max(maxProductQty, quantity);
        minProductQty = maxProductQty /n;
        
        int minProductQtyPossible = maxProductQty;
        while(minProductQty <= maxProductQty) {
            int avgProductQty = minProductQty +(maxProductQty -minProductQty) /2;
            
            if(isPossibleQty(quantities, n, avgProductQty)) {
                minProductQtyPossible = avgProductQty;
                maxProductQty = avgProductQty -1;
            } else {
                minProductQty = avgProductQty +1;
            }
        }
        
        return minProductQtyPossible;
    }
    
    private boolean isPossibleQty(int[] quantities, int stores, int productQtyLimit) {
        int currStoresUsed = 0;
        for(int qty :quantities) {
            currStoresUsed += Math.ceil((double)qty /productQtyLimit);
            if(currStoresUsed > stores) return false;
        }
        return true;
    }
}