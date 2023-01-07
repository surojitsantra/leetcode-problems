class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        const int N = gas.size();
        
        int totalGas = 0, totalCost = 0;
        int curGas = 0, startingPoint = 0;
        
        for(int i = 0; i < N; i++) {
            
            totalGas += gas[i];
            totalCost += cost[i];
            curGas += gas[i] -cost[i];
            
            if(curGas < 0) {
                startingPoint = i +1;
                curGas = 0;
            }
        }
        return (totalGas < totalCost)? -1 : startingPoint; 
    }
};