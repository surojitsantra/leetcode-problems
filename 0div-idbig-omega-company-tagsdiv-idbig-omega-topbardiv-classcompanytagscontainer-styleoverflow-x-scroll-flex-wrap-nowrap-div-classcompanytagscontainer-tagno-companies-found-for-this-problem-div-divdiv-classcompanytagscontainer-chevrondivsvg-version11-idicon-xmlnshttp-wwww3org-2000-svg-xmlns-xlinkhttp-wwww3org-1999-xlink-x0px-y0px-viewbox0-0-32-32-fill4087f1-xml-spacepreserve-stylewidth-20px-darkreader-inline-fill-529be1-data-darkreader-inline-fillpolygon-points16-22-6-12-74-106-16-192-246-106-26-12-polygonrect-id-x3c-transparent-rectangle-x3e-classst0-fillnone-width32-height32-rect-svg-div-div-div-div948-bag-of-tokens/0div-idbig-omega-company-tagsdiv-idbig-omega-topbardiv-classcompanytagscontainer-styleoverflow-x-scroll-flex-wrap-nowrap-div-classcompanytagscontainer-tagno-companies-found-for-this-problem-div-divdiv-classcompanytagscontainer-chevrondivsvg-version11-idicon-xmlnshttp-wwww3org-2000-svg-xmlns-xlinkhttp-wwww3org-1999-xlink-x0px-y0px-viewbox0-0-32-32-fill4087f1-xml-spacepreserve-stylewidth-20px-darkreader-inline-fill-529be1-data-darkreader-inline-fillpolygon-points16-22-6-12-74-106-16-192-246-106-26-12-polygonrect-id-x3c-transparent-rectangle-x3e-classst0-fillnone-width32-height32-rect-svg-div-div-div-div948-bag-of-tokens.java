class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        
        final int N = tokens.length;
        int i = 0, j = N -1;
        
        int maxScore = 0;
        int currScore = 0;
        
        while(i <= j) {
            if(power >= tokens[i]) {
                power -= tokens[i++];
                currScore++;
            } else if(i < j && currScore > 0) {
                power += tokens[j--];
                currScore--;
            } else {
                return maxScore;
            }
            maxScore = Math.max(maxScore, currScore);
        }
        
        return maxScore;
    }

}