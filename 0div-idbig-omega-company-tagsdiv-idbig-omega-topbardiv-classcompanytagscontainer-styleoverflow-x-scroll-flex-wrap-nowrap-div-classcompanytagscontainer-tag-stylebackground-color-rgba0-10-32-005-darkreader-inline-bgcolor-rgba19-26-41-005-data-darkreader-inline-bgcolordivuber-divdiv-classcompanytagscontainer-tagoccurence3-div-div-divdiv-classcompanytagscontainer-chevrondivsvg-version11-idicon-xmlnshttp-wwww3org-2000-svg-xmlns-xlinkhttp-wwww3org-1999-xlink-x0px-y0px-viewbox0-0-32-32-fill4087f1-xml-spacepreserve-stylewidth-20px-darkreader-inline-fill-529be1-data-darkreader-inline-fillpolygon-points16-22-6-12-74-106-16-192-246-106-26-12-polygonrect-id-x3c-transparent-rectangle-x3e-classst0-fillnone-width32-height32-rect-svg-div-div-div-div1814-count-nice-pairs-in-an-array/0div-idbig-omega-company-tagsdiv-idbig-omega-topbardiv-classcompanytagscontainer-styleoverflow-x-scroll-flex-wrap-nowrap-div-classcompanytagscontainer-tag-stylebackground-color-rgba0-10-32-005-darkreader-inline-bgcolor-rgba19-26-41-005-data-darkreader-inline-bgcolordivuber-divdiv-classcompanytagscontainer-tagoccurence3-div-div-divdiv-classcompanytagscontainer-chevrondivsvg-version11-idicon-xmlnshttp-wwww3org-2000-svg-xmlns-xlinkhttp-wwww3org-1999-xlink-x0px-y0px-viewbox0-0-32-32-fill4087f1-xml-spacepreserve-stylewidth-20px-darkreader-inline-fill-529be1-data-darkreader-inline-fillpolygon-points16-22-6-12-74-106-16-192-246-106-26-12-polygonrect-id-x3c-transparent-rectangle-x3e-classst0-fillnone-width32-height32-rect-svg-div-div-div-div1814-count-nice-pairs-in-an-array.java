class Solution {
    
    private int MOD = 1000000000 +7;
    
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> combFreq = new HashMap<>();
        
        int count = 0;
        
        for(int num :nums) {
            int revNum = rev(num);
            int comb = num -revNum;
            int freq = combFreq.getOrDefault(comb, 0);
            
            count = (count %MOD + freq %MOD) %MOD;
            
            combFreq.put(comb, freq +1);
        }

        return count %MOD;
    }
    
    private int rev(int num) {
        int ans = 0;
        
        while(num > 0) {
            int r = num %10;
            ans = ans *10 +r;
            num /= 10;
        }
        
        return ans;
    }
}