class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long powerSum = 0;
        for(int power :batteries) {
            powerSum += power;
        }
        
        long low = 1, high = powerSum /n;
        
        long ans = 0;
        
        while(low <= high) {
            long mid = low +(high -low) /2;
            
            long totalPower = 0;
            for(int power :batteries) {
                totalPower += Math.min(mid, power);
            }
            
            if(totalPower >= (long)n *mid) {
                ans = mid;
                low = mid +1;
            } else {
                high = mid -1;
            }
            
        }
        return ans;
        
    }
}