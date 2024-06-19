class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        final int N = bloomDay.length;
        
        if(m > N /k) return -1;
        
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int low = 1;
        int minDays = high;
        
        while(low <= high) {
            int mid = (high -low) /2 +low;
            if(isPossibleDay(bloomDay, m, k, mid)) {
                minDays = mid;
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        
        return minDays;
    }
    
    private boolean isPossibleDay(int[] bloomDay, int m, int k, int day) {
        int currBouquets = 0;
        int currFlowers = 0;
        
        for(int i = 0; i < bloomDay.length; i++) {
            int bDay = bloomDay[i];
            if(bDay <= day) currFlowers++;
            else currFlowers = 0;
            if(currFlowers == k) {
                currBouquets++;
                currFlowers = 0;
            }
            if(currBouquets >= m) return true;
        }
        return false;
    }
}