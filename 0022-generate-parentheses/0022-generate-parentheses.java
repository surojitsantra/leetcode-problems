class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        generate(0, 0, n, "", parenthesis);
        
        return parenthesis;
    }
    
    private void generate(int open, int close, int n, String currPar, List<String> parenthesis) {
        if(open > n || close > n) return;
        if(open == n && close == n) {
            parenthesis.add(currPar);
            return;
        }
        
        generate(open +1, close, n, currPar +"(", parenthesis);
        if(open > close) {
            generate(open, close +1, n, currPar +")", parenthesis);
        }
        
    }
    
}