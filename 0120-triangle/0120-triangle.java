class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int M = triangle.size();
        int N = triangle.get(M -1).size();
        
        int[] down = new int[N];
        
        for(int r = M -1; r >= 0; r--) {
            N = triangle.get(r).size();
            int[] curr = new int[N];
            
            for(int c = N -1; c >= 0; c--) {
                int one = Integer.MAX_VALUE;
                if(r +1 < M) {
                    one = down[c];
                }
                
                int two = Integer.MAX_VALUE;
                if(r +1 < M && c +1 < N +1) {
                    two = down[c +1];
                }
                if(one == two && one == Integer.MAX_VALUE) {
                    one = 0;
                }

                curr[c] = Math.min(one, two) +triangle.get(r).get(c);
            }
            
            down = curr;
            
        }
        
        return down[0];
    }
    
}