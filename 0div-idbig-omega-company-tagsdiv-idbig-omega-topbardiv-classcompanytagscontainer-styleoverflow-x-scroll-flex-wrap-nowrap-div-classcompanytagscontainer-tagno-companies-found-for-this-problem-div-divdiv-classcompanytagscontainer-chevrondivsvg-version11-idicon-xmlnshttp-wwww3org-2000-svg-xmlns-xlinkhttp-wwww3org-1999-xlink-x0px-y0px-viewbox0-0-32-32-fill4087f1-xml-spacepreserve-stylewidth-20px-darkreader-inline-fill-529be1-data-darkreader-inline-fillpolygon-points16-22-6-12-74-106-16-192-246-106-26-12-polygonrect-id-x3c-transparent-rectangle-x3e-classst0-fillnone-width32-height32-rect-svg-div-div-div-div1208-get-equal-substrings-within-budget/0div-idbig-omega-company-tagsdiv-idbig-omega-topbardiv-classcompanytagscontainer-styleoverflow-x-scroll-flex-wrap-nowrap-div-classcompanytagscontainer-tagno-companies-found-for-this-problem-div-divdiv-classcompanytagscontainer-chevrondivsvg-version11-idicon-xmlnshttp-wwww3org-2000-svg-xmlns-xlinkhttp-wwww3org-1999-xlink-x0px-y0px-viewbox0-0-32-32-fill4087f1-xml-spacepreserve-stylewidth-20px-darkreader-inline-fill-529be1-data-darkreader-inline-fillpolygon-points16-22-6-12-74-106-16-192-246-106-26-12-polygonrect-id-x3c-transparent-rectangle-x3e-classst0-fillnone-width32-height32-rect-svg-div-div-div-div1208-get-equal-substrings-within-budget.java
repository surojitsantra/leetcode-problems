class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        final int N = s.length();
        int i = 0, j = 0;
        int maxCount  = 0;
        
        while(j < N) {
            int ch1 = (int)s.charAt(j);
            int ch2 = (int)t.charAt(j);
            int cost = Math.abs(ch1 -ch2);
            
            if(cost <= maxCost) {
                maxCount = Math.max(maxCount, j -i +1);
                maxCost -= cost;
                j++;
            } else {
                maxCost += Math.abs((int)s.charAt(i) -(int)t.charAt(i));
                i++;
            }
        }
        
        return maxCount;
    }
}