class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> nums = new ArrayList<>();
        
        generateLexicalNumbers(0, n, nums);
        
        return nums;
    }
    
    private void generateLexicalNumbers(int currNo, int limit, List<Integer> nums) {
        
        for(int digit = 0; digit <= 9; digit++) {
            int nextNumber = currNo *10 + digit;
            if(nextNumber > 0 && nextNumber <= limit) {
                nums.add(nextNumber);
                generateLexicalNumbers(nextNumber, limit, nums);
            }
        }
        
    }
    
}