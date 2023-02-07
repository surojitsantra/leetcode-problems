class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        int totalFrute = 0;
        unordered_map<int, int> fruteFreq;
        
        int low = 0, high = 0;
        
        while(high < fruits.size()) {
            int fruiteType = fruits[high];
            fruteFreq[fruiteType]++;
            while(fruteFreq.size() > 2) {
                int removeFruiteType = fruits[low];
                fruteFreq[removeFruiteType]--;
                if(fruteFreq[removeFruiteType] == 0) fruteFreq.erase(removeFruiteType);
                low++;
            }
            
            totalFrute = max(totalFrute, (high -low +1));
            high++;
        }
        
        return totalFrute;
    }
};