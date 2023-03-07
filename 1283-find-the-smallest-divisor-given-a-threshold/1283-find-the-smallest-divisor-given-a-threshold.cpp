class Solution {
public:
    int smallestDivisor(vector<int>& nums, int threshold) {
        //Bin search
        const int N = nums.size();
        
        //search space
        int low = 1, high = *max_element(nums.begin(), nums.end());
        
        int divisior = high;
        
        while(low <= high) {
            int mid = low +(high -low)/2;
            
            if(isPossibleDivisior(nums, mid, threshold)) {
                divisior = mid;
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return divisior;
    }
    
private:
    bool isPossibleDivisior(vector<int>& nums, int divisior, int threshold) {
        int sum = 0;
        for(int num :nums) {
            sum += ceil((double)num /divisior);
            if(sum > threshold) return false;
        }
        return true;
    }
};