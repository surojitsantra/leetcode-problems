class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        if(k < arr[0]) return k;
        
        int low = 0, high = arr.size() -1;
        
        while(low <= high) {
            int mid = low +(high -low)/2;
            int missingNumbersCount = arr[mid] -(mid +1);
            
            if(missingNumbersCount < k) {
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        
        low--;
        int missingNumbersCount = arr[low] -(low +1);
        
        return arr[low] +(k -missingNumbersCount);
    }
};