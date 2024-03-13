class Solution {
    public int pivotInteger(int n) {
        int left = 1, right = n;
        int totalSum = (n *(n +1)) /2;
        
        while(left <= right) {
            int mid = (left +right) /2;
            int leftSum = (mid *(mid +1)) /2;
            int rightSum = totalSum -leftSum +mid;
            
            if(leftSum == rightSum) return mid;
            else if(leftSum > rightSum) {
                right = mid -1;
            } else {
                left = mid +1;
            }
            
        }
        
        return -1;
    }
}