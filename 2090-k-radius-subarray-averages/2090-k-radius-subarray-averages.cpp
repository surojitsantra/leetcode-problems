class Solution {
public:
    vector<int> getAverages(vector<int>& nums, int k) {
        if(k == 0) return nums;
        
        const int N = nums.size();
        vector<int> res(N, -1);
        
        if(k *2 +1 > N) return res;
        
        long windowSum = 0;
        for(int i = 0; i < k *2; i++) {
            windowSum += nums[i];
        }
        
        long dividor = k *2 +1;
        
        for(int i = k; i < N -k; i++) {
            windowSum += nums[i +k];
            res[i] = windowSum /dividor;
            windowSum -= nums[i -k];
        }
        
        return res;
    }
};