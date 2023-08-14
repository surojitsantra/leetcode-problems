class Solution {
    public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        
        return kthLargest(nums, k -1, 0, N -1);
    }
    
    private int kthLargest(int[] nums, int k, int start, int end) {
        int pos = partition(nums, start, end);
        
        if(pos == k) return nums[k];
        
        if(pos > k) {
            return kthLargest(nums, k, start, pos -1);
        } else {
            return kthLargest(nums, k, pos +1, end);
        }
    }
    
    private int partition(int[] nums, int start, int end) {
        int i = start +1, j = end;
        int pivot = start;
        
        while(i <= j) {
            if(nums[i] > nums[pivot]) i++;
            else if(nums[j] <= nums[pivot]) j--;
            else swap(nums, i++, j--);
        }
        swap(nums, pivot, j);
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}