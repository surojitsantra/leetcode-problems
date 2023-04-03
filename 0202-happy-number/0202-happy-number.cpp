class Solution {
    int digitSquare(int n) {
        int sum = 0;
        while(n) {
            sum = sum+pow(n%10, 2);
            n = n/10;
        }
        return sum;
    }
public:
    bool isHappy(int n) {
        int slow = n, fast = n;
        
        do {
            slow = digitSquare(slow);
            fast = digitSquare(fast);
            fast = digitSquare(fast);
        } while(slow != fast);
        
        return(slow == 1);
    }
};