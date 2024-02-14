class Solution {
    public int[] rearrangeArray(int[] nums) {
        final int N = nums.length;
        
        boolean[] positiveNumsIdxFlag = new boolean[N];
        boolean[] negativeNumsIdxFlag = new boolean[N];
        
        for(int i = 0; i < N; i++) {
            int num = nums[i];
            if(num > 0) positiveNumsIdxFlag[i] = true;
            else negativeNumsIdxFlag[i] = true;
        }
        
        int[] sortedArray = new int[N];
        
        int i = 0, k = 0;
        while(i < N) {
            if(positiveNumsIdxFlag[i]) {
                sortedArray[k] = nums[i];
                k += 2;
            }
            i++;
        }
        
        i = 0;
        k = 1;
        while(i < N) {
            if(negativeNumsIdxFlag[i]) {
                sortedArray[k] = nums[i];
                k += 2;
            }
            i++;
        }
        
        return sortedArray;
    }
}