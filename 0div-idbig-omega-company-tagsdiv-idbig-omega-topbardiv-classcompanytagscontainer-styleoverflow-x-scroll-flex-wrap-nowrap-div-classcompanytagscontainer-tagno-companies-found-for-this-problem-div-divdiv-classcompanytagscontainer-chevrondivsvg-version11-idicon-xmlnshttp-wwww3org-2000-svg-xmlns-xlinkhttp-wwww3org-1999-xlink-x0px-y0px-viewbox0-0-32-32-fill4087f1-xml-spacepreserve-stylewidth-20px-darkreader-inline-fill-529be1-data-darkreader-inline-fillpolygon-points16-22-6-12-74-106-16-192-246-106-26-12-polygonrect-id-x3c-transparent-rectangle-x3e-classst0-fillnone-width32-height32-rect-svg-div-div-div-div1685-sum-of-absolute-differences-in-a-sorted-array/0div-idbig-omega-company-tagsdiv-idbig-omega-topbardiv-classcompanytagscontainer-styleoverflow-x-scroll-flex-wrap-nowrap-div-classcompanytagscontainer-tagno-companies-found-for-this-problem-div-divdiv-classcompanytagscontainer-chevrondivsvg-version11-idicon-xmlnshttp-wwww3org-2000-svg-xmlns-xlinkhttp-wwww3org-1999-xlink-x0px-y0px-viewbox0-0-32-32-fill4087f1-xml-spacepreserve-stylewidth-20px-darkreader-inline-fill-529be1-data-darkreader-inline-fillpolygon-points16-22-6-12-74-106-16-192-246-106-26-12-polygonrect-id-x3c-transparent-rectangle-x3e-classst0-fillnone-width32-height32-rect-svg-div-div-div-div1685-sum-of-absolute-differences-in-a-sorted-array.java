class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        final int N = nums.length;
        int rightSum = 0, leftSum = 0;
        for(int num :nums) rightSum += num;
        
        int[] res = new int[N];
        
        for(int i = 0; i < N; i++) {
            int num = nums[i];
            
            long left = i *num;
            long right = (N -i) *num;
            
            res[i] = (int)((left -leftSum) + (rightSum -right));
            leftSum += num;
            rightSum -= num;
        }
        
        return res;
    }
}