class Solution {
public:
    string reversePrefix(string word, char ch) {
        const int N = word.size();
        int i = 0, j = 0;
        
        while(j < N && word[j] != ch) j++;
        if(j >= N) return word;
        
        while(i < j) {
            char t = word[i];
            word[i] = word[j];
            word[j] = t;
            i++;
            j--;
        }
        
        return word;
    }
};