class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        getAllPermutations(nums, 0, ans);
        
        return ans;
    }
    
    private void getAllPermutations(int[] nums, int i, List<List<Integer>> ans) {
        if(i == nums.length) {
            ans.add(IntStream.of(nums).boxed().collect(Collectors.toList()));
        }
        
        for(int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            
            getAllPermutations(nums, i +1, ans);
            
            swap(nums, i, j);
        }
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}