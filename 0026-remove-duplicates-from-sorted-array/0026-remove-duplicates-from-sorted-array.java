class Solution {
    public int removeDuplicates(int[] nums) {
        final int N = nums.length;
        int i = 0, j = 1;
        while(j < N) {
            if(nums[j] > nums[i]) {
                nums[++i] = nums[j];
            } else {
                j++;
            }
        }
        return i +1;
    }
}