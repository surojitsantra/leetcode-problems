class Solution {
    public boolean canSortArray(int[] nums) {
        final int N = nums.length;
        
        Map<Integer, Integer> numsSetBits = new HashMap<>();
        for(int num :nums) {
            numsSetBits.putIfAbsent(num, setBitCount(num));
        }
        
        for(int i = 0; i < N; i++) {
            int smallNoPos = i;
            for(int j = i; j < N; j++) {
                if(nums[j] < nums[smallNoPos]) {
                    smallNoPos = j;
                }
            }
            for(int j = smallNoPos; j > i; j--) {
                if(numsSetBits.get(nums[j]) == numsSetBits.get(nums[j -1])) {
                    swap(nums, j, j-1);
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private int setBitCount(int n) {
        if (n == 0)
            return 0;
        return (n &1) + setBitCount(n >>1);
    }
    
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    
}