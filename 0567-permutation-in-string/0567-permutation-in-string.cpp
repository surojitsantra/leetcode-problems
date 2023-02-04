class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if(s1.size() > s2.size()) return false;
        
        vector<int> charFreq(26, 0);
        vector<int> tempCharFreq(26, 0);
        
        for(int i = 0; i < s1.size(); i++) {
            charFreq[s1[i] -'a']++;
            tempCharFreq[s2[i] -'a']++;
        }
        
        if(charFreq == tempCharFreq) return true;
        
        for(int k = 0, i = s1.size(); i < s2.size(); i++, k++) {
            tempCharFreq[s2[k] -'a']--;
            tempCharFreq[s2[i] -'a']++;
            
            if(charFreq == tempCharFreq) return true;
        }
        
        return false;
    }
};