class Solution {
    public long minEnd(int n, int x) {
        long lastNum = x;
        for(int i = 1; i < n; i++) {
            lastNum = (lastNum +1) | x;
        }
        return lastNum;
    }
}