class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        final int M = nums1.length, N = nums2.length;
        int i = 0, j = 0;
        
        while(i < M && j < N) {
            if(nums1[i] == nums2[j]) return nums1[i];
            if(nums1[i] < nums2[j]) i++;
            else j++;
        }
        
        return -1;
    }
}