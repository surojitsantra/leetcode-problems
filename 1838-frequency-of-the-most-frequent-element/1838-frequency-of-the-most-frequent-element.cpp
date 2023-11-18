class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end(), greater<int>());
        
        const int N = nums.size();
        int i = 0, j = 0;
        int maxFreq = 0;
        
        while(j < N) {
            int diff = nums[i] -nums[j];
            if(k >= diff) {
                k = k -diff;
                int freq = j -i +1;
                maxFreq = max(maxFreq, freq);
                j++;
            } else {
                i++;
                int prevDiff = nums[i -1] -nums[i];
                k += (prevDiff *(j -i));
            }
        }
        
        return maxFreq;
    }
};