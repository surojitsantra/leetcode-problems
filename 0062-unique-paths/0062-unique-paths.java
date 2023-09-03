class Solution {
    public int uniquePaths(int m, int n) {
        if(m < n) {
            return uniquePaths(n, m);
        }
        
        m--;
        n--;
        
        long res = 1;
        
        for(int i = m +1, j = 1; i <= m +n; i++, j++) {
            res = res *i;
            res = res /j;
        }
        
        return (int)res;
    }
}