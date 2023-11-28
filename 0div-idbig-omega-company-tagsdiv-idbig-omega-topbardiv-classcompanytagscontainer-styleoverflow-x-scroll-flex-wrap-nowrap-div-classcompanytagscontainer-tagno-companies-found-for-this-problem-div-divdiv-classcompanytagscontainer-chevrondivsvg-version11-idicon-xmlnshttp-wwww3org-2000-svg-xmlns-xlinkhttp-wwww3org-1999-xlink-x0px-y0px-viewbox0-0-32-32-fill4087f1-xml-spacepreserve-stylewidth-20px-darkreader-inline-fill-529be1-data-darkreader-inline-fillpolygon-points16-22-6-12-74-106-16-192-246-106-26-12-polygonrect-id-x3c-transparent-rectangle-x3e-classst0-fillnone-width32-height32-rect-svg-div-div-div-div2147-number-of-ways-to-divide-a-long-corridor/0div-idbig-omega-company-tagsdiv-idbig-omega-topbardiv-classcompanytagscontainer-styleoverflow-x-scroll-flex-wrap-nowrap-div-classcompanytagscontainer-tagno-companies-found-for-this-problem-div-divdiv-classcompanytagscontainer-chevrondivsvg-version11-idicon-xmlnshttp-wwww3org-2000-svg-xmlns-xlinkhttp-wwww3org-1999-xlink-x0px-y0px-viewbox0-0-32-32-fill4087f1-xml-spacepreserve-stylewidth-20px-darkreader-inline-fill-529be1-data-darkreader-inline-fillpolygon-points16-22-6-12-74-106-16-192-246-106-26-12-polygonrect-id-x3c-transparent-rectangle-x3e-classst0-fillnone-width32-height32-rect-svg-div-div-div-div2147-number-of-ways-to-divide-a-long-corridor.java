class Solution {
    
    private final int MOD = 1000000000 +7;
    
    public int numberOfWays(String corridor) {
        final int N = corridor.length();
        
        long ans = 1;
        int seatComb = 0;
        int gap = -1;
        
        for(int i = 0; i < N; i++) {
            char ch = corridor.charAt(i);
            
            if(ch == 'S') {
                seatComb++;
                if(gap == -1) gap = 1;
                if(seatComb == 2) {
                    seatComb = 0;
                    ans = ((ans %MOD) *(gap %MOD)) %MOD;
                    gap = 1;
                }
            } else if(seatComb == 0 && gap != -1) {
                gap++;
            }
        }
        
        if(seatComb > 0 || gap == -1) return 0;
        return (int)(ans %MOD);
    }
}