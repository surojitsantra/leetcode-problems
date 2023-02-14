class Solution {
public:
    string addBinary(string a, string b) {
        const int M = a.size(), N = b.size();
        
        string ans = "";
        
        int carry = 0;
        int i = M -1, j = N -1;
        while(i >= 0 || j >= 0 || carry) {
            if(i >= 0) carry += (a[i] -'0');
            if(j >= 0) carry += (b[j] -'0');
            
            ans.push_back((carry %2) +'0');
            carry = carry /2;
            
            i--; j--;
        }
        
        reverse(ans.begin(), ans.end());
        return ans;
    }
};