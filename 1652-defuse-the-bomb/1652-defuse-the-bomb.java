class Solution {
    public int[] decrypt(int[] code, int k) {
        final int N = code.length;
        int[] decrypted = new int[N];
        if(k == 0) return decrypted;
        
        int start = 1, end = k, currSum = 0;
        if(k < 0) {
            start = N -Math.abs(k);
            end = N -1;
        }
        
        for(int i = start; i <= end; i++) currSum += code[i];
        
        for(int i = 0; i < N; i++) {
            decrypted[i] = currSum;
            currSum -= code[start %N];
            start++;
            end++;
            currSum += code[end %N];
        }
        
        return decrypted;
    }
}