class Solution {
public:
    vector<int> shuffle(vector<int>& nums, int n) {
        for(int i = 0, j = n; i < n; i++, j++) {
            int firstNum = nums[i];
            int secondNum = nums[j];
            
            int combinedNum = ((firstNum <<10) | secondNum);
            nums[i] = combinedNum;
        }
        
        int allOnes = 1023; //(2^10 -1)
        
        for(int i = n -1, j = 2*n -1; i >= 0; i--, j -= 2) {
            int combinedNum = nums[i];
            int firstNum = (combinedNum >>10);
            int secondNum = (combinedNum &allOnes);
            
            nums[j] = secondNum;
            nums[j -1] = firstNum;
        }
        
        return nums;
    }
};