class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        unordered_map<int, int> tasksFreq;
        
        for(int task :tasks) tasksFreq[task]++;
        
        int minTimeReq = 0;
        
        for(auto it :tasksFreq) {
            int freq = it.second;
            if(freq < 2) return -1;
            
            if(freq %3 == 0) {
                minTimeReq += freq /3;
            } else {
                minTimeReq += freq /3 +1;
            }
            
        }
        
        return minTimeReq;
    }
};