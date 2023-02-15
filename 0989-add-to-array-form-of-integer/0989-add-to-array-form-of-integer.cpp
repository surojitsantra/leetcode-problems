class Solution {
public:
    vector<int> addToArrayForm(vector<int>& num, int k) {
        vector<int> result;
        
        int carry = 0;
        int i = num.size() -1;
        
        while(i >= 0 || k > 0 || carry) {
            if(i >= 0) {
                carry += num[i];
                i--;
            }
            
            if(k > 0) {
                carry += (k %10);
                k = k /10;
            }
            
            result.push_back(carry %10);
            carry = carry /10;
        }
        
        reverse(result.begin(), result.end());
        return result;
    }
};