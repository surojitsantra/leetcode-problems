class Solution {
public:
    bool detectCapitalUse(string word) {
        if(word.size() <= 1) return true;
        
        bool firstCharLower = isLower(word[0]);
        bool curCharLower = isLower(word[1]);
        
        if(firstCharLower && !curCharLower) return false;
        
        for(int i = 2; i < word.size(); i++) {
            if(isLower(word[i]) != curCharLower) return false;
            curCharLower = isLower(word[i]);
        }
        
        return true;
    }
    
private:
    bool isLower(char ch) {
        return(ch >= 'a' && ch <= 'z');
    }
};