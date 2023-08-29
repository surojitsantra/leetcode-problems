class Solution {
    public int bestClosingTime(String customers) {
        final int N = customers.length();
        
        int nCount = 0;
        int yCount = 0;
        
        for(char ch :customers.toCharArray()) {
            if(ch == 'N') nCount++;
            else yCount++;
        }
        
        int currPenalty = Integer.MAX_VALUE;
        int minTime = N;
        int yMaintain = 0;
        
        for(int i = 0; i < N; i++) {
            int penalty = yCount -yMaintain;
            if(penalty < currPenalty) {
                currPenalty = penalty;
                minTime = i;
            }
            if(customers.charAt(i) == 'Y') yMaintain++;
            else yMaintain--;
        }
        
        if(currPenalty <= nCount){
            minTime = Math.min(minTime, N);
        } else {
            minTime = N;
        }
        
        return minTime;
    }
}