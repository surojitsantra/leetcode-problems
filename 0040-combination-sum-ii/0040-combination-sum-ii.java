class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(candidates, 0, target, new ArrayList<>(), combinations);
        
        return combinations;
    }
    
    private void generateCombinations(int[] candidates, int pos, int rem, 
                                      List<Integer> currCombination, 
                                      List<List<Integer>> combinations) {
        
        if(rem == 0) {
            combinations.add(new ArrayList<>(currCombination));
            return;
        }
        if(rem < 0 || pos >= candidates.length) return;
        
        //take
        currCombination.add(candidates[pos]);
        generateCombinations(candidates, pos +1, rem -candidates[pos], currCombination, combinations);
        currCombination.remove(currCombination.size() -1);
        
        //skip
        while(pos +1 < candidates.length && candidates[pos] == candidates[pos +1]) pos++;
        generateCombinations(candidates, pos +1, rem, currCombination, combinations);
    }
    
}