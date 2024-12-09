class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int low = 0, high = 0;
        for(int weight :weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        
        int minWeightReq = high;
        while(low <= high) {
            int mid = low +((high -low) /2);
            
            if(isEnoughWeight(weights, mid, days)) {
                minWeightReq = mid;
                high = mid -1;
            } else {
                low = mid +1;
            }
            
        }
        
        return minWeightReq;
    }
    
    private boolean isEnoughWeight(int[] weights, int maxCapacity, int days) {
        int currWeight = 0;
        
        for(int weight :weights) {
            if(currWeight +weight > maxCapacity) {
                days--;
                currWeight = 0;
            }
            currWeight += weight;
        }
        
        return (days > 0 && currWeight <= maxCapacity);
    }
    
}