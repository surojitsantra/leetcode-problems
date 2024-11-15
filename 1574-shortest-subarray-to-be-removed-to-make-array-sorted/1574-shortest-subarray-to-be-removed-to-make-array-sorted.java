class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        final int N = arr.length;
        int leftStart = 0, leftEnd = 0, rightStart = N -1, rightEnd = N -1;
        
        while(leftEnd +1 < N && arr[leftEnd] <= arr[leftEnd +1]) {
            leftEnd++;
        }
        if(leftEnd == rightEnd) return 0;
        
        while(rightStart > leftEnd && arr[rightStart -1] <= arr[rightStart]) {
            rightStart--;
        }
        
        int minSubarrayRemove = Math.min(rightEnd- leftEnd, rightStart);;
        int i = leftStart, j = rightStart;
        while(i <= leftEnd && j <= rightEnd) {
            if(arr[i] <= arr[j]) {
                minSubarrayRemove = Math.min(minSubarrayRemove, j -i -1);
                i++;
            } else {
                j++;
            }
        }
        
        return minSubarrayRemove;
    }
}