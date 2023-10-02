class Solution {
    public boolean winnerOfGame(String colors) {
        final int N = colors.length();
        
        int aliceCanMove = 0, bobCanMove = 0;
        
        int i = 0;
        while(i < N) {
            char ch = colors.charAt(i);
            int count = 1;
            
            while(i +1 < N && colors.charAt(i +1) == ch) {
                count++;
                i++;
            }
            if(ch == 'A') {
                aliceCanMove += Math.max(0, count -2);
            } else {
                bobCanMove += Math.max(0, count -2);
            }
            i++;
        }
        
        return (aliceCanMove > bobCanMove);
    }
}