class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;
        final int N = s.length();
        long[] lastOccurance = new long[26];
        
        long count = 1;
        
        for(char ch :s.toCharArray()) {
            long prevCount = count;
            count = (count *2) %MOD;
            
            count -= lastOccurance[ch -'a'];
            count %= MOD;
            
            lastOccurance[ch -'a'] = prevCount;
        }
        count--;
        if (count < 0) count += MOD;
        return (int)count;
    }
}