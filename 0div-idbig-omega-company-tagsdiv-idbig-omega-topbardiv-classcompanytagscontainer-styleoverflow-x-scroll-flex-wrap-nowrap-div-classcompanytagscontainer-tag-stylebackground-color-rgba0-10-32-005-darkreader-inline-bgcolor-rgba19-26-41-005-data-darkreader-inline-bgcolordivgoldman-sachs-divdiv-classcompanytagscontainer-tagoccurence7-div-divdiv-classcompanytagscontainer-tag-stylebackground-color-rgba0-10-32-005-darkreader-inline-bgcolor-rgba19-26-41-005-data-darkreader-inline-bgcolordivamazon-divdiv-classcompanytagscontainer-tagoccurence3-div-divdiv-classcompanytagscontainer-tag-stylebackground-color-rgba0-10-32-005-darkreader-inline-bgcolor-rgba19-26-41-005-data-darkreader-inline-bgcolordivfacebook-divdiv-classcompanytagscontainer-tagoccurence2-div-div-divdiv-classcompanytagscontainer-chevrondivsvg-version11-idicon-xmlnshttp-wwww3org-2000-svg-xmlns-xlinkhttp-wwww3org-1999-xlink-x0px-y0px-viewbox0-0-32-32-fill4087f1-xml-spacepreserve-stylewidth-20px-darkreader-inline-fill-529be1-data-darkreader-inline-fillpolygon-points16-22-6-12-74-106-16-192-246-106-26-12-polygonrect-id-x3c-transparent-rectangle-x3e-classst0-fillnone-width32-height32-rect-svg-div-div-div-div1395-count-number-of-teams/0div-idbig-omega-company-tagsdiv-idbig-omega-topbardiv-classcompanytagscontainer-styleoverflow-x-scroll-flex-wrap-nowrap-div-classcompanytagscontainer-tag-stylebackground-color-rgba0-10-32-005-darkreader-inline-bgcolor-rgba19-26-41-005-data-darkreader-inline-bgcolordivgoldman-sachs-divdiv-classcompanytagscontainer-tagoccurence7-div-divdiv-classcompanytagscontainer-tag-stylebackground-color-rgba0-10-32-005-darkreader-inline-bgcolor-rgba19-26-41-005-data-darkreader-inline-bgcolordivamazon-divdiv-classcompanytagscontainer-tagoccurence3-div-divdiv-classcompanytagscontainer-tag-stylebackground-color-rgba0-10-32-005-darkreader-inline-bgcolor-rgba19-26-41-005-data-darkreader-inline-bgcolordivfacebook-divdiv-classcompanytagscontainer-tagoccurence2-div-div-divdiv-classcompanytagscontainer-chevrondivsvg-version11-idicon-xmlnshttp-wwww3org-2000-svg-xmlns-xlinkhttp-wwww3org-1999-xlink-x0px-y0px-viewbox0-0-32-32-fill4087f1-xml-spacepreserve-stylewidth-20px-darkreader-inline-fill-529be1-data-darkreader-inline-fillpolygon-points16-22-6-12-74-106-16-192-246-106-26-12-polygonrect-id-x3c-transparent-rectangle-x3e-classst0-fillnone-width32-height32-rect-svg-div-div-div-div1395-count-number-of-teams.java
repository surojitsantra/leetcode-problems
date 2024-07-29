class Solution {
    public int numTeams(int[] rating) {
        final int N = rating.length;
        
        int[] smallerNoCounts = new int[N];
        int[] biggerNoCounts = new int[N];
        int counts = 0;
        
        for(int i = 0; i < N; i++) {
            int smallerNo = 0;
            for(int j = 0; j < i; j++) {
                if(rating[i] > rating[j])  {
                    smallerNo++;
                    counts += smallerNoCounts[j];
                }
            }
            smallerNoCounts[i] = smallerNo;
            
        }
        
        for(int i = N -1; i >= 0; i--) {
            int smallerNo = 0;
            for(int j = i +1; j < N; j++) {
                if(rating[i] > rating[j]) {
                    smallerNo++;
                    counts += biggerNoCounts[j];
                }
            }
            biggerNoCounts[i] = smallerNo;
        }
        
        return counts;
    }
    
}