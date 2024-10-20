class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch :expression.toCharArray()) {
            if(ch == ',') {
                continue;
            } else if(ch == ')') {
                int trueCount = 0, falseCount = 0;
                while(stack.peek() != '(') {
                    char op = stack.pop();
                    if(op == 't') trueCount++;
                    else falseCount++;
                }
                stack.pop();
                char operator = stack.pop();
                
                char ans = '#';
                if(operator == '|') {
                    if(trueCount > 0) ans = 't';
                    else ans = 'f';
                } else if(operator == '&') {
                    if(falseCount > 0) ans = 'f';
                    else ans = 't';
                } else {
                    if(trueCount > 0) ans = 'f';
                    else ans = 't';
                }
                
                stack.push(ans);
                
            } else {
                stack.push(ch);
            }
        }
        
        return (stack.peek() == 't');
    }
}