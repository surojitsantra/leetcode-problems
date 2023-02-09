class Solution {
public:
    long long distinctNames(vector<string>& ideas) {
        
        long long ans = 0;
        
        unordered_set<string> wordMap[26];
        
        for(string& name :ideas) {
            wordMap[name[0] -'a'].insert(name.substr(1));
        }
        
        for(int i = 0; i < 26; i++) {
            for(int j = i +1; j < 26; j++) {
                int unique1 = 0;
                for(auto& subWord :wordMap[i]) {
                    if(wordMap[j].count(subWord) == 0) unique1++;
                }
                
                int unique2 = 0;
                for(auto& subWord :wordMap[j]) {
                    if(wordMap[i].count(subWord) == 0) unique2++;
                }
                
                ans += unique1 *unique2;
            }
        }
        
        return ans *2;
    }
};