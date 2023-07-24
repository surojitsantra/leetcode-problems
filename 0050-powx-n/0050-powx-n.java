class Solution {
    public double myPow(double x, int n) {
        if(n < 0) return 1/ pow(x, n);
        return pow(x, n);
    }
    
    private double pow(double x, int n) {
        if(n == 0) return 1;
        
        double halfPow = pow(x, n /2);
        if((n &1) == 1) {
            return x *halfPow *halfPow;
        }
        return halfPow *halfPow;
    }
}