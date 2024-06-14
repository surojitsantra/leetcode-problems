class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int thresHold = nums[0];
        int moves = 0;
        
        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if(num <= thresHold) {
                moves += thresHold -num +1;
                thresHold++;
            } else {
                thresHold = num;
            }
        }
        
        return moves;
        
    }
}