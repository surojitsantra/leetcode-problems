class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return lds(nums);
    }
    
    private ArrayList<Integer> lds(int[] nums) {
        final int N = nums.length;
        
        int[] dp = new int[N];
        int[] parentIdx = new int[N];
        
        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            parentIdx[i] = i;
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] %nums[j] == 0 && dp[i] < dp[j] +1) {
                    dp[i] = dp[j] +1;
                    parentIdx[i] = j;
                }
            }
        }
        
        int maxLenIdx = 0;
        for(int i = 1; i < N; i++) {
            if(dp[i] > dp[maxLenIdx]) {
                maxLenIdx = i;
            }
        }
        
        //backTrack
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while(parentIdx[maxLenIdx] != maxLenIdx) {
            list.add(nums[maxLenIdx]);
            maxLenIdx = parentIdx[maxLenIdx];
        }
        list.add(nums[maxLenIdx]);
        
        Collections.reverse(list);
        
        return list;
    }
    
}