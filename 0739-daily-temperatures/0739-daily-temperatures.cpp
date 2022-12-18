class Temperature {
    
    public:
        int day, degree;
        Temperature(int day, int degree) {
            this->day = day;
            this->degree = degree;
        }
    
};

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        
        //Will use decreasing monotonic stack concept
        
        vector<int> result(temperatures.size());
        
        stack<Temperature> st;
        
        for(int i = temperatures.size()-1; i >= 0; i--) {
            while(!st.empty() && temperatures[i] >= st.top().degree) {
                st.pop();
            }
            
            if(st.empty()) {
                result[i] = 0;
            } else {
                result[i] = st.top().day - i;
            }
            st.push(Temperature(i, temperatures[i]));
        }
        
        
        return result;
        
    }
};