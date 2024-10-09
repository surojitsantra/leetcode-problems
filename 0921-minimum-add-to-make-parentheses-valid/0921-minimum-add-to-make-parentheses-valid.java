class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char brac :s.toCharArray()) {
            if(brac == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(brac);
            }
        }
        
        return stack.size();
    }
}