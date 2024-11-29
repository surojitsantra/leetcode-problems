class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubSets(nums, 0, nums.length, new ArrayList<>(), subsets);
        
        return subsets;
    }
    
    private void generateSubSets(int[] nums, int pos, final int N, List<Integer> currSubset, List<List<Integer>> subsets) {
        if(pos >= N) {
            subsets.add(new ArrayList<>(currSubset));
            return;
        }
        
        //take all
        currSubset.add(nums[pos]);
        generateSubSets(nums, pos +1, N, currSubset, subsets);
        currSubset.remove(currSubset.size() -1);
        
        //skip
        while(pos +1 < N && nums[pos] == nums[pos +1]) pos++;
        generateSubSets(nums, pos +1, N, currSubset, subsets);
        
    }
    
}