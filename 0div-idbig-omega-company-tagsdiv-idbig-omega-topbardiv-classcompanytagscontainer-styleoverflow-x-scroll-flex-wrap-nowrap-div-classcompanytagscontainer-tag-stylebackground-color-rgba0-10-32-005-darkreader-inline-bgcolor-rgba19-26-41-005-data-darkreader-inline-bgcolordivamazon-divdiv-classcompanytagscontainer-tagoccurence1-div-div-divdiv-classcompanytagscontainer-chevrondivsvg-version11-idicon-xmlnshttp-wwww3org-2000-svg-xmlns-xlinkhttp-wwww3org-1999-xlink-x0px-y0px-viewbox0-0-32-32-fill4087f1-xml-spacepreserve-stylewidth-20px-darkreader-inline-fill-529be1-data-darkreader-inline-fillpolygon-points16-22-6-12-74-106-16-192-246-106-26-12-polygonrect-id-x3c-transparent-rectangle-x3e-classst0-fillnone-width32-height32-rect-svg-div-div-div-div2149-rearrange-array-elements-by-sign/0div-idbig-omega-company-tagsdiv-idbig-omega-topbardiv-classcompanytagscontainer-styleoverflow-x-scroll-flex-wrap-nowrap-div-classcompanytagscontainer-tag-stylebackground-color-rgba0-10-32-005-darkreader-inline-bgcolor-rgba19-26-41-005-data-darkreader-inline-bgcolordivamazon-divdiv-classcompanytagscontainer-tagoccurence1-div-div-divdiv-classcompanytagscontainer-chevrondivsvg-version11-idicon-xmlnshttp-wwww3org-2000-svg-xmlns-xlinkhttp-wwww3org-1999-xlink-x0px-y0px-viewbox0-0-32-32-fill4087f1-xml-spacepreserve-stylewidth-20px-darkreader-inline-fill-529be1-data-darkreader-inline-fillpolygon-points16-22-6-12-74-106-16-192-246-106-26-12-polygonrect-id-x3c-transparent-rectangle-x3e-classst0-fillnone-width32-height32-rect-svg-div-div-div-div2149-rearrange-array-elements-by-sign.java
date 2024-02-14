class Solution {
    public int[] rearrangeArray(int[] nums) {
        final int N = nums.length;
        
        int[] sortedArray = new int[N];
        int posIdx = 0, negIdx = 1;
        for(int i = 0; i < N; i++) {
            int num = nums[i];
            if(num > 0) {
                sortedArray[posIdx] = num;
                posIdx += 2;
            } else {
                sortedArray[negIdx] = num;
                negIdx += 2;
            }
        }
        
        return sortedArray;
    }
}