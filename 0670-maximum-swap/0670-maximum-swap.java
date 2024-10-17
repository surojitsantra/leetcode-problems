class Solution {
    public int maximumSwap(int num) {
        char[] number = String.valueOf(num).toCharArray();
        final int N = number.length;
        
        int smallPoint = 0;
        while(smallPoint < N -1) {
            if(number[smallPoint] < number[smallPoint +1]) {
                break;
            }
            smallPoint++;
        }
        
        if(smallPoint == N -1) {
            return num;
        }
        
        int nextBigPoint = smallPoint;
        for(int i = N -1; i > smallPoint; i--) {
            if(number[i] > number[nextBigPoint]) {
                nextBigPoint = i;
            }
        }
        
        for(int i = 0; i < nextBigPoint; i++) {
            if(number[i] < number[nextBigPoint]) {
                swap(number, i, nextBigPoint);
                break;
            }
        }
        
        return Integer.parseInt(String.valueOf(number));
    }
    
    private void swap(char[] number, int x, int y) {
        char ch = number[x];
        number[x] = number[y];
        number[y] = ch;
    }
    
}