class Solution {
public:
    int countOdds(int low, int high) {
        int noOfOdd = (high -low +1) /2;
        if((low &1) && (high &1)) noOfOdd++;
        
        return noOfOdd;
    }
};