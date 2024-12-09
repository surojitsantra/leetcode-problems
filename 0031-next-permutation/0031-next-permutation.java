class Solution {
    public void nextPermutation(int[] nums) {
        final int N = nums.length;
        if(N < 2) return;
        
        int breakingPoint = N -2;
        
        while(breakingPoint >= 0) {
            int curr = nums[breakingPoint];
            int next = nums[breakingPoint +1];
            
            if(curr < next) {
                break;
            }
            breakingPoint--;
        }
        
        
        reverse(nums, breakingPoint +1, N -1);
        
        if(breakingPoint >= 0) {
            int x = breakingPoint;
            while(nums[breakingPoint] >= nums[x]) {
                x++;
            }
            swap(nums, breakingPoint, x);
        }
        
    }
    
    private void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
}