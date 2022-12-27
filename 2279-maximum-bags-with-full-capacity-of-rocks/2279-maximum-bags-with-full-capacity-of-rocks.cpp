class Solution 
{
public:
    static bool compare(vector<int>& bag1, vector<int>& bag2) {
        return (bag1[1] -bag1[0] < bag2[1] -bag2[0]);
    }

    int maximumBags(vector<int>& capacity, vector<int>& rocks, int additionalRocks) {
        const int N = capacity.size();
        
        vector<vector<int>> bags(N); 

        for(int i = 0; i < N; i++) {
            bags[i] = {rocks[i], capacity[i]};
        }

        sort(bags.begin(), bags.end(), compare);

        int fullBags = 0;
        
        for(auto bag :bags) {
            if((bag[1] -bag[0]) <= additionalRocks) additionalRocks -= (bag[1] -bag[0]);       
            else break;
            
            fullBags++;
        }
        return fullBags;
    }
};