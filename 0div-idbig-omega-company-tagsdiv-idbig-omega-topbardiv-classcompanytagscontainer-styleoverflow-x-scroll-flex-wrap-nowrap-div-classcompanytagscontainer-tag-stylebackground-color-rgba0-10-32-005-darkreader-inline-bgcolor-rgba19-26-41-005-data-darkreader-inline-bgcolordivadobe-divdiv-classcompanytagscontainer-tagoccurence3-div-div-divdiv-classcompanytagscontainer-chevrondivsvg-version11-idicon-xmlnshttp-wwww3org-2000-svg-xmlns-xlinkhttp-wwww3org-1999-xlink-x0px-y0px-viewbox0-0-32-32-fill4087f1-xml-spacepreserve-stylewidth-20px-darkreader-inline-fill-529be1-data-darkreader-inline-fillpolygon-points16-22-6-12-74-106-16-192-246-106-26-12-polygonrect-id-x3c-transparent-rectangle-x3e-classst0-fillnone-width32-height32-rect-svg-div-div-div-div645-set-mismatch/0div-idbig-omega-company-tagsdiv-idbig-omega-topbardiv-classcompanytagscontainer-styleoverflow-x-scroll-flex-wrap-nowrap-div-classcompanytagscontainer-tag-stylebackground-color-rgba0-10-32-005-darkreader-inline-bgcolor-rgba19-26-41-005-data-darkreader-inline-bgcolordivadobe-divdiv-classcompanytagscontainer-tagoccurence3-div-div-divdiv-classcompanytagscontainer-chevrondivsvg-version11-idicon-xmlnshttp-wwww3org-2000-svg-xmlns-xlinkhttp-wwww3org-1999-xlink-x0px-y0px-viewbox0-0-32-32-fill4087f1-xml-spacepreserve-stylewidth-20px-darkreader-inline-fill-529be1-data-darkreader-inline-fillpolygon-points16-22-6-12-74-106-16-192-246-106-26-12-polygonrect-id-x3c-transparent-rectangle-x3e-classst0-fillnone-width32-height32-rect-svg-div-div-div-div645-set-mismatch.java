class Solution {
    public int[] findErrorNums(int[] nums) {
        final int N = nums.length;
        
        int duplicate = 0, missing = 0;
        for(int i = 0; i < N; i++) {
            int num = Math.abs(nums[i]);
            int idx = num -1;
            
            if(nums[idx] < 0) duplicate = num;
            else {
                nums[idx] = -nums[idx];
            }
        }
        
        for(int i = 0; i < N; i++) {
            if(nums[i] > 0) missing = i +1;
        }
        
        return new int[]{duplicate, missing};
    }
}