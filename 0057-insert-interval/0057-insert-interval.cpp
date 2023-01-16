class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
         vector<vector<int>> mergedIntervals;
        
        for(auto interval :intervals) {
            
    //  the new interval is after the range of other interval
            if(interval[1] < newInterval[0]) mergedIntervals.push_back(interval);
    // the new interval's range is before the other
            else if(newInterval[1] < interval[0]){
                mergedIntervals.push_back(newInterval);
                newInterval = interval;//updating the new interval
            }
    // the new interval is in the range of the other interval
            else{
                newInterval[0] = min(newInterval[0], interval[0]);
                newInterval[1] = max(newInterval[1], interval[1]);
            }    
        }
    //At the end after the loop just add the updated newIntervals
        mergedIntervals.push_back(newInterval);
        return mergedIntervals;
    }
};