class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        
        generateCombinations(candidates, 0, target, candidates.length, currList, combinations);
        
        return combinations;
    }
    
    private void generateCombinations(int[] candidates, int pos, int rem, int N, 
                                      List<Integer> currList, List<List<Integer>> combinations) {
        if(rem == 0) {
            combinations.add(new ArrayList<>(currList));
            return;
        }
        if(rem < 0 || pos >= N) {
            return;
        }
        
        //skip
        generateCombinations(candidates, pos +1, rem, N, currList, combinations);
        
        //take
        currList.add(candidates[pos]);
        generateCombinations(candidates, pos, rem -candidates[pos], N, currList, combinations);
        currList.remove(currList.size() -1);
        
    }
    
}