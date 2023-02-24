class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        priority_queue<int> maxHeap;
        
        int minVal = INT_MAX;
        for(int num :nums) {
            if(num &1) num *= 2;
            maxHeap.push(num);
            minVal = min(minVal, num);
        }
        
        int minDeviation = INT_MAX;
        
        while(true) {
            int maxVal = maxHeap.top();
            maxHeap.pop();
            
            minDeviation = min(minDeviation, maxVal -minVal);
            if(maxVal &1) break;
            
            maxVal = maxVal >>1;
            minVal = min(minVal, maxVal);
            
            maxHeap.push(maxVal);
        }
        
        return minDeviation;
    }
};