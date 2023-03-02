class Solution {
public:
    int compress(vector<char>& chars) {
        const int N = chars.size();
        int ans = 0;
        
        int i = 0, j = 0;
        while(i < N) {
            const char letter = chars[i];
            int count = 0;
            
            while (i < N && chars[i] == letter) {
                ++count;
                ++i;
            }
            
            chars[ans++] = letter;
            
            if (count > 1) {
                for (const char c : to_string(count)) {
                    chars[ans++] = c;
                }
            }
        }
        
        return ans;
    }
};