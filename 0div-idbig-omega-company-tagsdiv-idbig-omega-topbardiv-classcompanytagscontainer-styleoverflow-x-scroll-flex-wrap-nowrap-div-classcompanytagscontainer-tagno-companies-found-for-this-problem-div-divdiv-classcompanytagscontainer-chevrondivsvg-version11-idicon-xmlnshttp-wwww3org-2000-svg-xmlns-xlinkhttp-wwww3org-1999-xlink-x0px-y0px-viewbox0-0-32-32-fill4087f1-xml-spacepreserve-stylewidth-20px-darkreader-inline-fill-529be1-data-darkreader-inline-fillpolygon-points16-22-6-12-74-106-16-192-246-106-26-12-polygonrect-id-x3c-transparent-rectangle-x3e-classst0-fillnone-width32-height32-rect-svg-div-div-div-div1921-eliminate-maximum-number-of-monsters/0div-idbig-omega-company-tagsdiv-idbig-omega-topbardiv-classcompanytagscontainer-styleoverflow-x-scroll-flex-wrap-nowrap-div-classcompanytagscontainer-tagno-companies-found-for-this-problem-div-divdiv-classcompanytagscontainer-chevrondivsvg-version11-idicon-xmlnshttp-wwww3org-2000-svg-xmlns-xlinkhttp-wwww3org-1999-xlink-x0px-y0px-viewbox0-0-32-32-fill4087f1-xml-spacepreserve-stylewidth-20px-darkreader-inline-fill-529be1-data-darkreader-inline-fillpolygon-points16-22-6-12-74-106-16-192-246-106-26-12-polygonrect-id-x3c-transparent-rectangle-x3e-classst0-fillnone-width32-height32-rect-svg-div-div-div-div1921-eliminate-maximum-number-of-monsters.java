class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        final int N = dist.length;
        
        int[] remainingTimeReachTown = new int[N];
        
        for(int i = 0; i < N; i++) {
            int d = dist[i];
            int s = speed[i];
            
            remainingTimeReachTown[i] = (int)(Math.ceil((double)d /s));
        }
        
        Arrays.sort(remainingTimeReachTown);
        
        for(int i = 0; i < N; i++) {
            int r = remainingTimeReachTown[i];
            
            if(i >= r) {
                return i;
            }
            
        }
        
        return N;
    }
}