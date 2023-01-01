class Solution {
public:
    bool wordPattern(string pattern, string s) {
        const int N = pattern.size();
        vector<string> stringMapHelper(26, "");
        
        unordered_set<string> wordsSet;
        
        int pos = 0;
        for(int i = 0; i < N; i++) {
            string nextWord = getNextWord(s, pos);
            int index = pattern[i] -'a';
            
            if(nextWord.empty()) return false;
            if(!stringMapHelper[index].empty() && stringMapHelper[index] != nextWord) return false;
            if(stringMapHelper[index] != nextWord && wordsSet.count(nextWord)) return false;
            
            stringMapHelper[index] = nextWord;
            wordsSet.insert(nextWord);
        }
        return (pos >= s.size());
    }
private:
    string getNextWord(string& s, int& pos) {
        string nextWord = "";
        
        while(pos < s.size() && s[pos] != ' ') {
            nextWord.push_back(s[pos]);
            ++pos;
        }
        ++pos;
        
        return nextWord;
    }
};