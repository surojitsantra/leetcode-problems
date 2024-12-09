class Solution {
    public void rotate(int[] nums, int k) {
        final int N = nums.length;
        k = k %N;
        
        if(k == 0) return;
        
        //full rorate
        rotate(nums, 0, N -1);
        
        rotate(nums, 0, k -1);
        rotate(nums, k, N -1);
        
    }
    
    private void rotate(int[] nums, int i, int j) {
        while(i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }
    
}