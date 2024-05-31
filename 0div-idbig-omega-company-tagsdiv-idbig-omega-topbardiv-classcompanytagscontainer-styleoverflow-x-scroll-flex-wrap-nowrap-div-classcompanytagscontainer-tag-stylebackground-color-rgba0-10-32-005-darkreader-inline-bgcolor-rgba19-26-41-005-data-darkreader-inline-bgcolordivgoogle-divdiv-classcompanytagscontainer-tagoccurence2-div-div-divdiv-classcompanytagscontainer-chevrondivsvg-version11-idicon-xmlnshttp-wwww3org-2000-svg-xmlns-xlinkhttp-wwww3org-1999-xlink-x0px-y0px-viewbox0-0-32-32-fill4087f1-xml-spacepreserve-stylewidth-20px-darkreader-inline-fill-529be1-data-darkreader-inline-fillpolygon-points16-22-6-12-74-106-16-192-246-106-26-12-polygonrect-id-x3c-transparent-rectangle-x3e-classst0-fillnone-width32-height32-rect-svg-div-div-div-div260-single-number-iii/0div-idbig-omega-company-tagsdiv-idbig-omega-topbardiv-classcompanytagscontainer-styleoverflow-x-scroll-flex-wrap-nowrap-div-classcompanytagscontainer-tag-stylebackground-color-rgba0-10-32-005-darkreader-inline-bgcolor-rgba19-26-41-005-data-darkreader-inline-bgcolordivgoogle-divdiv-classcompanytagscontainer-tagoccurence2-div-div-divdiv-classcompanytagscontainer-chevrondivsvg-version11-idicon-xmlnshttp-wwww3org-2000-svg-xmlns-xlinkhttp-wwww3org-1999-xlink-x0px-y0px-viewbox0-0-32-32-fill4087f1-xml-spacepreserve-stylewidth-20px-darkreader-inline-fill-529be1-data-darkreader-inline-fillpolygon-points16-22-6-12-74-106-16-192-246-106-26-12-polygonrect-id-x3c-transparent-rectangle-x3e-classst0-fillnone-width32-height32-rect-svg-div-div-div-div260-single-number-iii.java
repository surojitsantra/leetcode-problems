class Solution {
    public int[] singleNumber(int[] nums) {
        final int N = nums.length;
        int xor = 0;
        for(int num:nums) {
            xor = xor ^num;
        }
        
        int posOfDiffBit = 0;
        int tempXor = xor;
        while((tempXor &1) == 0) {
            posOfDiffBit++;
            tempXor = (tempXor >> 1);
        }
        
        int groupA = 0, groupB = 0;
        for(int num :nums) {
            if((num &(1 << posOfDiffBit)) == 0) {
                groupA = groupA ^ num;
            } else {
                groupB = groupB ^ num;
            }
        }
        
        return new int[] {groupA, groupB};
    }
}