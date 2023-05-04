class Solution {
public:
    string predictPartyVictory(string senate) {
        const int N = senate.size();
        
        vector<bool> banned(N, false);
        while(true) {
            for(int i = 0; i < N; i++) {
                if(banned[i]) continue;
                int j = i;
                bool flag = false;
                while((++j %N) != i && !flag) {
                    int k = j %N;
                    if(banned[k] || senate[k] == senate[i]) continue;
                    banned[k] = true;
                    flag = true;
                }
                
                if(!flag)
                    return(senate[i] == 'R')? "Radiant" : "Dire";
            }
        }
        
        return "";
    }
};