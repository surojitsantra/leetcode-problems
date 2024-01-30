class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> helperStack = new Stack<>();
        
        for(String s :tokens) {
            if(isOperend(s)) {
                int secondNum = helperStack.pop();
                int firstNum = helperStack.pop();
                
                helperStack.push(calculate(firstNum, s, secondNum));
            } else {
                helperStack.push(Integer.valueOf(s));
            }
        }
        
        return helperStack.pop();
    }
    
    private int calculate(int num1, String operend, int num2) {
        
        switch(operend) {
            case "+" : return num1 +num2;
            case "-" : return num1 -num2;
            case "*" : return num1 *num2;
            case "/" : return num1 /num2;
            default : return 0;
        }
    }
    
    private boolean isOperend(String s) {
        switch(s) {
            case "+" : return true;
            case "-" : return true;
            case "*" : return true;
            case "/" : return true;
            default : return false;
        } 
    }
    
}