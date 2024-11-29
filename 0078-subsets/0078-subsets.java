class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        final int N = nums.length;
        List<List<Integer>> subsets = new ArrayList<>();
        
        for(int i = 0; i < Math.pow(2, N); i++) {
            List<Integer> set = new ArrayList<>();
            
            for(int j = 0; j < Math.min(N, 32); j++) {
                boolean take = ((i &(1 <<j)) == 0);
                if(take) {
                    set.add(nums[j]);
                }
            }
            
            subsets.add(set);
        }
        
        return subsets;
    }
}