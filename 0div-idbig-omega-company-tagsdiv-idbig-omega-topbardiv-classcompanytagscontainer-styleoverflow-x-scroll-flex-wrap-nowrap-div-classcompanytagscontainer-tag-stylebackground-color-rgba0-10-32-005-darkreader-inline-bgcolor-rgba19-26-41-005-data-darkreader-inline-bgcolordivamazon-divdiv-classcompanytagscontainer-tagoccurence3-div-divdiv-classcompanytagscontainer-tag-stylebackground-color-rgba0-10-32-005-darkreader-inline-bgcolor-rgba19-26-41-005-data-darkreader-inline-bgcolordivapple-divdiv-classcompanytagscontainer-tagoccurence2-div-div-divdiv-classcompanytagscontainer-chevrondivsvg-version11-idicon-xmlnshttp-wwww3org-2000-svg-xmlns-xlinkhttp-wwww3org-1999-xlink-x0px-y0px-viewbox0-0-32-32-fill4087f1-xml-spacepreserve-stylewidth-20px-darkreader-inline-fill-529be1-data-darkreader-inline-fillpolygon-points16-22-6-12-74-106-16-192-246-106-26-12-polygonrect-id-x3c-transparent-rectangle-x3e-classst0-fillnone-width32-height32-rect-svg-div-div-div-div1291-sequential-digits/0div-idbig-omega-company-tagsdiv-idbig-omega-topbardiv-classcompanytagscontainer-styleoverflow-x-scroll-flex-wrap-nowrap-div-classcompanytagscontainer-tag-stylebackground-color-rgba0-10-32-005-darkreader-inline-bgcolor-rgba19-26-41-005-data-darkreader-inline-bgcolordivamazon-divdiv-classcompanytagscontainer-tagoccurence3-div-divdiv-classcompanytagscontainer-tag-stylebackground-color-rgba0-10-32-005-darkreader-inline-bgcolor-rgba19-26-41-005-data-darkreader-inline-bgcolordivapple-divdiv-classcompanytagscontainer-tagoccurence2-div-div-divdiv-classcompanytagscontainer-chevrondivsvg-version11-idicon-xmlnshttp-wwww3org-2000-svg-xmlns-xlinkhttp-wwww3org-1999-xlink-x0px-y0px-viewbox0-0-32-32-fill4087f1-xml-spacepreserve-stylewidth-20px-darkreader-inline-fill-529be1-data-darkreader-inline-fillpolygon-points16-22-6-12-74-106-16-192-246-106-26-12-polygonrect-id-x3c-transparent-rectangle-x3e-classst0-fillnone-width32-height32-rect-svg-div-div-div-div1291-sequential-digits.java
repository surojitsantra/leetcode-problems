class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            dfs(i, (i +1) %10, low, high, ans);
        }  
        Collections.sort(ans);
        return ans;
    }
    
    private void dfs(int num, int digit, int low, int high, List<Integer> ans) {
        if(num > high) return;
        if(num >= low) ans.add(num);
        if(digit == 0) return;
        
        dfs((num *10) +digit, (digit +1) %10, low, high, ans);
        
    }
    
}