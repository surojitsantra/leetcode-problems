class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> nums = new ArrayList<>();
        
        for (int start = 1; start <= 9; start++) {
            generateLexicalNumbers(start, n, nums);
        }
        
        return nums;
    }
    
    private void generateLexicalNumbers(int currNo, int limit, List<Integer> nums) {
        if(currNo > limit) {
            return;
        }
        nums.add(currNo);
        
        for(int i = 0; i <= 9; i++) {
            int nextNumber = currNo *10 + i;
            if (nextNumber > limit) {
                break;
            }
            generateLexicalNumbers(nextNumber, limit, nums);
        }
        
    }
    
}