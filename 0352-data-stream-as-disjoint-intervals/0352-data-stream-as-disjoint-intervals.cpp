class SummaryRanges {
private:
    set<int> dataSet;
    
public:
    SummaryRanges() {
        
    }
    
    void addNum(int value) {
        dataSet.insert(value);
    }
    
    vector<vector<int>> getIntervals() {
        vector<vector<int>> result;
        int start = -1;
        int end = -1;
        
        for(auto num :dataSet) {
            if(start == -1) start = end = num;
            else if(num == end +1) end++;
            else {
                result.push_back({start, end});
                start = end = num;
            }
        }
        if(start != -1) {
            result.push_back({start, end});
        }
        
        return result;
    }
};

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges* obj = new SummaryRanges();
 * obj->addNum(value);
 * vector<vector<int>> param_2 = obj->getIntervals();
 */