class Solution {
    public int[] findArray(int[] pref) {
        final int N = pref.length;
        
        int[] ans = new int[N];
        
        int prevXor = 0;
        
        for(int i = 0; i < N; i++) {
            int num = pref[i];
            ans[i] = num ^prevXor;
            prevXor = prevXor ^ans[i];
        }
        
        return ans;
    }
}