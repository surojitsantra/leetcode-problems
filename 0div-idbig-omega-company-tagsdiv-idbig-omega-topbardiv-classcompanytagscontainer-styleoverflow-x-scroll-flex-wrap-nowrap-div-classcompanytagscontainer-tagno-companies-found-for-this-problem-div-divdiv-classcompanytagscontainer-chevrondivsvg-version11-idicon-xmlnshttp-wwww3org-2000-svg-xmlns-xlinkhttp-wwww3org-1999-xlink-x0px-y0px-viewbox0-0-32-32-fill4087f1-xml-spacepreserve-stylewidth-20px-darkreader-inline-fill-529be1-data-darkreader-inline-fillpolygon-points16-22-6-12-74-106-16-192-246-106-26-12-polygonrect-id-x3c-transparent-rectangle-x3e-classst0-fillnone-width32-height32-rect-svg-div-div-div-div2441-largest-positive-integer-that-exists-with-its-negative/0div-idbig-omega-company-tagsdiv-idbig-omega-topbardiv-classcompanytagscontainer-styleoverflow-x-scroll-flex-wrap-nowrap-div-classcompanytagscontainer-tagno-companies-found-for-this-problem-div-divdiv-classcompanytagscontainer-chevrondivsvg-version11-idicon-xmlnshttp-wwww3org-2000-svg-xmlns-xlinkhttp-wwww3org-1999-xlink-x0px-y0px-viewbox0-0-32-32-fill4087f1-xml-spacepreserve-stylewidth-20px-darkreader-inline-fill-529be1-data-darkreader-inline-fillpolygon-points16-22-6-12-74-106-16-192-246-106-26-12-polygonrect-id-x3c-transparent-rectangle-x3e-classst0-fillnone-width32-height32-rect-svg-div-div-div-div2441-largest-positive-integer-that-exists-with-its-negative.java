class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> helperSet = new HashSet<>();
        
        int ans = -1;
        for(int num :nums) {
            if(helperSet.contains(-num)) {
                ans = Math.max(Math.abs(num), ans);
            }
            helperSet.add(num);
        }
        
        return ans;
    }
}