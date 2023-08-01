class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<Integer> currCombination = new ArrayList<>();
        List<List<Integer>> allCombinations = new ArrayList<>();
        getCombinations(1, n, k, currCombination, allCombinations);
        
        return allCombinations;
    }
    
    private void getCombinations(int i, int n, int k, List<Integer> currCombination, List<List<Integer>> allCombinations) {
        if(k == 0) {
            allCombinations.add(new ArrayList<>(currCombination));
            return;
        }
        if(i > n) return;
        
        for(int j = i; j <= n; j++) {
            currCombination.add(j);
            getCombinations(j +1, n, k -1, currCombination, allCombinations);
            currCombination.remove(currCombination.size() -1);
        }
    }
    
}