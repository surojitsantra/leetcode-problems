class Solution {
    
    private final long MOD = 1000000000 +7;
    
    public int numberOfWays(String corridor) {
        final int N = corridor.length();
        int firstSeatPoint = -1, lastSeatPoint = -1, totalSeat = 0;
        
        for(int i = 0; i < N; i++) {
            char ch = corridor.charAt(i);
            if(ch == 'S') {
                if(firstSeatPoint == -1) firstSeatPoint = i;
                lastSeatPoint = i;
                totalSeat++;
            }
        }
        
        if(totalSeat < 2 || (totalSeat &1) == 1) return 0;
        
        long ans = 1;
        int i = firstSeatPoint;
        int gap = 1;
        while(i <= lastSeatPoint) {
            char ch = corridor.charAt(i);
            if(ch == 'S') {
                int nextSeat = findNextSeatPos(corridor, i, lastSeatPoint);
                if(nextSeat == -1) return 0;
                i = nextSeat;
                ans = ((ans %MOD) * (gap %MOD)) %MOD;
                gap = 1;
            } else {
                gap++;
            }
            i++;
        }
        
        return (int)(ans %MOD);
    }
    
    private int findNextSeatPos(String corridor, int i, int lastSeatPoint) {
        for(int j = i +1; j <= lastSeatPoint; j++) {
            if(corridor.charAt(j) == 'S') return j;
        }
        return -1;
    }
}