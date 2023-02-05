class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        if(p.size() > s.size()) return {};
        
        vector<int> ans;
        
        vector<int> charFreq(26, 0);
        vector<int> tempCharFreq(26, 0);
        
        for(int i = 0; i < p.size(); i++) {
            charFreq[p[i] -'a']++;
            tempCharFreq[s[i] -'a']++;
        }
        
        if(charFreq == tempCharFreq) ans.push_back(0);
        
        for(int k = 0, i = p.size(); i < s.size(); i++, k++) {
            tempCharFreq[s[k] -'a']--;
            tempCharFreq[s[i] -'a']++;
            
            if(charFreq == tempCharFreq) {
                ans.push_back(k +1);
            }
        }
        
        return ans;
    }
};